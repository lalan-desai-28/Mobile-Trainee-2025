package com.lalan.android_learning.retrofit

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lalan.android_learning.R
import com.lalan.android_learning.retrofit.adapters.UserAdapter
import com.lalan.android_learning.retrofit.models.User
import com.lalan.android_learning.retrofit.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetRequestExampleActivity : AppCompatActivity() {

    private var retrofitObject: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val userService: UserService = retrofitObject
        .create(UserService::class.java)

    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private fun handleError() {
        Toast.makeText(
            baseContext,
            "Error fetching data, Check your internet connection!",
            Toast.LENGTH_LONG
        ).show()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get_request_example)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainRecyclerView = findViewById(R.id.mainRecyclerView)
        progressBar = findViewById(R.id.progressBar)

        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        val usersCall: Call<List<User>> = userService.getUsers()

        usersCall.enqueue(object : Callback<List<User>> {
            override fun onResponse(p0: Call<List<User>>, usersResponse: Response<List<User>>) {
                progressBar.visibility = View.GONE

                if (usersResponse.code() != 200) {
                    handleError()
                    return
                }

                usersResponse.body()
                    ?.let {
                        mainRecyclerView.adapter = UserAdapter(it)
                    }
            }

            override fun onFailure(p0: Call<List<User>>, p1: Throwable) {
                progressBar.visibility = View.GONE
                handleError()
            }
        })
    }
}