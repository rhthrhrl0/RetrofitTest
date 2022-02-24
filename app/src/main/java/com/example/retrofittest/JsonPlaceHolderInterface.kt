package com.example.retrofittest


import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceHolderInterface {
    @GET("posts")
    suspend fun getPost(): Response<AllPostsResponse>
    //코루틴 스코프 안에서 사용하기 위해서 suspend 키워드 작성
    //만약 요청하는 양식에 바디가 필요하다면 함수의 매개변수를 만들고 @Body어노테이션 달면 됨
    //Response<T>는 요청 내용을 json으로 컨버터가 알아서 바꿔줌.

}