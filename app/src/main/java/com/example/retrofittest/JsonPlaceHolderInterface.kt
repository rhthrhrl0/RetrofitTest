package com.example.retrofittest

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderInterface {
    @GET("posts")
    fun getPost(): Call<AllPostsResponse>
}