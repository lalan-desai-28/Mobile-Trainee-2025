package com.lalan.android_learning.retrofit.services

import com.lalan.android_learning.retrofit.models.Credentials
import com.lalan.android_learning.retrofit.models.LoginResponse
import com.lalan.android_learning.retrofit.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    @GET("/users")
    fun getUsers(): Call<List<User>>

    @Headers("Content-Type: application/json")
    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<LoginResponse>
}