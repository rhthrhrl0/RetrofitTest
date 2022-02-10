package com.example.retrofittest


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*


class MainViewModel : ViewModel() {
    private val _postList = MutableLiveData<ArrayList<ResponseResult>>()
    val postList: LiveData<ArrayList<ResponseResult>>
        get() = _postList


    init {

        viewModelScope.launch {
            val dataResponse = SingletonObject.api.getPost()
            _postList.postValue(dataResponse.body())
            //메인스레드가 아닌 백그라운드 스레드에서
        }

    }
}

/** enqueue로 직접 받아오기
처음에 통신을 해서 받아옴.
val callPosts=SingletonObject.api.getPost()

//enqueue는 비동기 통신실행
callPosts.enqueue(object: Callback<AllPostsResponse> {
//onResponse는 통신 완료시의 콜백함수. 이것이 성공적으로 데이터 받은게 아님.
override fun onResponse(
call: Call<AllPostsResponse>,
response: Response<AllPostsResponse>
) {
if(response.isSuccessful()) {
//통신을 완료했는데 응답이 정상인 경우. 즉 응답코드가 200번대
Log.d("kmj","onResponse 성공,결과\n " +
"${response.body()?.get(2)?.body}")
_postList.value=response.body()
}else{
//통신을 완료했으나 받은 응답코드가 200이 아닌 경우.
Log.d("kmj","통신은 완료지만 실패")
}
}

//예외의 경우. 인터넷 끊김 등의 상황
override fun onFailure(call: Call<AllPostsResponse>, t: Throwable) {
Log.d("kmj","onFailure ${t.message}")
}
})
 **/


