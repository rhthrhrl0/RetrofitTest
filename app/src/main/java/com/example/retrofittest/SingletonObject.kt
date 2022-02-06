package com.example.retrofittest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object SingletonObject {
    //싱글톤 객체를 활용해서 레트로핏 구현
    private val retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val _api= retrofit.create(JsonPlaceHolderInterface::class.java)

    val api
        get()= _api
}