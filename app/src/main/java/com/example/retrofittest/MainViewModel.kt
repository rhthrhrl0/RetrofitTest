package com.example.retrofittest

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {
    private val _postList=MutableLiveData<ArrayList<ResponseResult>>()
    val postList:LiveData<ArrayList<ResponseResult>>
        get() = _postList

    init {
        //초기값은 아무거나 넣기. 이게 없으면 에러남...
        //아마 아직 받아오지 못했는데 다음작업을 하려고 해서 그런듯 함
        _postList.value= arrayListOf(ResponseResult("",0,"",0))

        // 이후 처음에 통신을 해서 받아옴.
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
    }




}