package com.lalan.android_learning.dependency_injection.task_one.data.domain.repository

import com.lalan.android_learning.dependency_injection.task_one.data.model.Todo

interface MyRepository {

    suspend fun makeNetworkCall(): List<Todo>
}