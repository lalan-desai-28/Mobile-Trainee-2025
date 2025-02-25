package com.lalan.android_learning.retrofit

import android.os.Bundle
import android.view.View
import android.widget.Button
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
import com.lalan.android_learning.retrofit.models.Credentials
import com.lalan.android_learning.retrofit.models.LoginResponse
import com.lalan.android_learning.retrofit.models.User
import com.lalan.android_learning.retrofit.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetRequestExampleActivity : AppCompatActivity() {

    private var getRetrofitObject: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())

        .build()

    private var postRetrofitObject: Retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val userService: UserService = getRetrofitObject
        .create(UserService::class.java)

    private val userServicePost: UserService = postRetrofitObject
        .create(UserService::class.java)

    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var postReqProgressBar: ProgressBar
    private lateinit var postReqButton: Button


    private fun handleError() {
        Toast.makeText(
            baseContext,
            "Error!",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun makePostReq() {

        val responseCall: Call<LoginResponse> =
            userServicePost.login(Credentials("mor_2314", "83r5^_"))

        responseCall.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(p0: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.code() == 200)
                    Toast.makeText(applicationContext, "Success!", Toast.LENGTH_LONG).show()
                else
                    handleError()
                postReqProgressBar.visibility = View.GONE
                postReqButton.visibility = View.VISIBLE
            }

            override fun onFailure(p0: Call<LoginResponse>, p1: Throwable) {
                handleError()
                postReqProgressBar.visibility = View.GONE
                postReqButton.visibility = View.VISIBLE
            }
        })
    }

    private fun makeGetReq() {
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
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        progressBar = findViewById(R.id.progressBar)
        postReqProgressBar = findViewById(R.id.postReqProgressBar)
        postReqButton = findViewById(R.id.postButton)

        makeGetReq()

        postReqButton.setOnClickListener {
            postReqProgressBar.visibility = View.VISIBLE
            postReqButton.visibility = View.INVISIBLE
            makePostReq()
        }
    }
}