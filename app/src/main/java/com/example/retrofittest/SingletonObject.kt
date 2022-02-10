package com.example.retrofittest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object SingletonObject {
    //레트로핏객체 구현
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/") //api서버 url을 넣기
        .addConverterFactory(GsonConverterFactory.create()) //필요한 컨버터를 넣음
        .build()

    //만들어진 레트로핏 객체에게 api인터페이스를 연결시켜줌
    private val _api = retrofit.create(JsonPlaceHolderInterface::class.java)

    val api
        get() = _api
}