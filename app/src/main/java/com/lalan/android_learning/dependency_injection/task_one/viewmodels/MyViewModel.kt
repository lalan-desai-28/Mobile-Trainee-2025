package com.lalan.android_learning.dependency_injection.task_one.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lalan.android_learning.dependency_injection.task_one.data.domain.repository.MyRepository
import com.lalan.android_learning.dependency_injection.task_one.data.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    private var todos = MutableLiveData<List<Todo>>()

    fun getAllTodos()  {
        CoroutineScope(Dispatchers.IO).launch {
            todos.postValue(repository.makeNetworkCall())
        }
    }

    fun observeTodosLiveData() : LiveData<List<Todo>>{
        return todos
    }
}