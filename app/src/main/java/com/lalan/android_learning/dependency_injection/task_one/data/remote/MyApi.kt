package com.lalan.android_learning.dependency_injection.task_one.data.remote

import com.lalan.android_learning.dependency_injection.task_one.data.model.Todo
import retrofit2.http.GET

interface MyApi  {

    @GET("todos")
    suspend fun makeNetworkCall() : List<Todo>

}