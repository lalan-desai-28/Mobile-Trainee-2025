package com.lalan.android_learning.activity.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lalan.android_learning.R

class LifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_lifecycle)
        Log.d(this.toString(), "onCreate: The onCreate function is called.")
    }

    override fun onStart() {
        super.onStart()
        Log.d(this.toString(), "onStart: the onStart function is called.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(this.toString(), "onResume: the onResume function is called.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(this.toString(), "onPause: the onPause function is called.")
    }


    override fun onStop() {
        super.onStop()
        Log.d(this.toString(), "onStop: the onStop function is called.")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(this.toString(), "onDestroy: the onDestroy function is called.")

    }

}