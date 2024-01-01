package com.example.kotlinproject

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("7181ed68-194b-4509-9889-7513e29345d4")
    fun getData(): Call<MyData>

    }