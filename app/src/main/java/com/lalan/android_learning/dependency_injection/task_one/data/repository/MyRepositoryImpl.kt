package com.lalan.android_learning.dependency_injection.task_one.data.repository

import com.lalan.android_learning.dependency_injection.task_one.data.domain.repository.MyRepository
import com.lalan.android_learning.dependency_injection.task_one.data.model.Todo
import com.lalan.android_learning.dependency_injection.task_one.data.remote.MyApi

class MyRepositoryImpl(private val api: MyApi) : MyRepository {

    override suspend fun makeNetworkCall(): List<Todo> {
        return api.makeNetworkCall()
    }


}