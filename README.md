# Product-Discovery
### Project có sử dụng:
* Kotlin
* MVVM
* Android achitecture components (live data, view model, databiding)
* Rxjava 2
* Retrofit
* Dagger 2
* ....
### Cấu trúc project gồm:
* data: bao gồm một số model, cung cấp các api sử dụng retrofit, các thành phần khác muốn sử dụng các api này phaỉ thông qua các respository
* di: chứa các thiết lập dagger ở đây cũng chứa một số dependency tồn tại trong toàn app
* screen: chứa màn hình search và detail
* utils: cung cấp một số utils được sử dụng cho toàn app như Extension, StringUtils, Constant...
### Hướng tiếp cận:
- Màn hinh search: user nhập vào keyword --> view model sẽ xử lý request thông qua repository --> repository tương tác với api, và sẽ trả về thành công hay thất bại cho view model --> view observe data thay đổi trong view model và update ui sử dụng databiding...
- Xử lý search: mục đích là hạn chế số request cần gửi khi search, giả dụ người dùng nhập vào abc trong một khoảng thời gian nhanh (trong app là 500 millisecond) thay vì gửi lần lượt request a ab abc  thì chỉ gửi 1 request abc.Trường hợp người dùng nhập vào abc,bỏ c và nhập lại c trong 500 millisecond thì sẽ không có request nào được thực hiện ( sử dụng distinctUntilChanged() )

```kotlin
object RxSearchObservable {
  fun fromView(searchView: SearchView): Observable<String> {
      val subject: PublishSubject<String> = PublishSubject.create()
      searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
          override fun onQueryTextSubmit(query: String?): Boolean {
              subject.onComplete()
              return true
          }
          override fun onQueryTextChange(text: String?): Boolean {
              subject.onNext(text!!)
              return true
          }
      })
      return subject
  }
}

 RxSearchObservable.fromView(viewDataBinding.layoutSearchBox.searchProduct)
            .debounce(SEARCH_DEBOUNCE_TIME, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .subscribeOn(viewModel.getSchedulerProvider().io())
            .observeOn(viewModel.getSchedulerProvider().ui())
            .subscribe {
                if (!it.isNullOrEmpty()) {
                    lastQuery = it.trim()
                    viewModel.searchProducts(lastQuery)
                    return@subscribe
                }
                lastQuery = ""
                viewModel.clearSearchedResult()
            }
``` 
- Màn hình detail ( chưa hoàn thành) : dự định sử dụng recyclerview cho việc scrolling bao gồm nhiều kiểu view type khác nhau trong screen để tránh giật lag khi scroll.
