package com.lalan.android_learning.dependency_injection.task_one

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lalan.android_learning.R
import com.lalan.android_learning.dependency_injection.task_one.data.adapter.TodoRecyclerViewAdapter
import com.lalan.android_learning.dependency_injection.task_one.viewmodels.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DITaskOneActivity : AppCompatActivity() {

    private lateinit var todosRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ditask_one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        todosRecyclerView = findViewById(R.id.todosRecyclerView)
        progressBar = findViewById(R.id.progressBar)

        todosRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getAllTodos()

        viewModel.observeTodosLiveData().observe(this) { listOfTodo ->
            if (listOfTodo != null) {
                todosRecyclerView.adapter = TodoRecyclerViewAdapter(listOfTodo)
                progressBar.visibility = View.GONE
            }
        }
    }
}