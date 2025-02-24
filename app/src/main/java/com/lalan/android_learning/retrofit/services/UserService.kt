package com.lalan.android_learning.retrofit.services

import com.lalan.android_learning.retrofit.models.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("/users")
    fun getUsers() : Call<List<User>>
}