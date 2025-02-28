package com.lalan.android_learning.multithreading

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.tan

class MultiThreadingLearning : AppCompatActivity() {


    private lateinit var t1TextView: TextView
    private lateinit var t2TextView: TextView
    private lateinit var t3TextView: TextView
    private lateinit var t4TextView: TextView

    private lateinit var t1Button: Button
    private lateinit var t2Button: Button
    private lateinit var t3Button: Button
    private lateinit var t4Button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multi_threading_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        t1Button = findViewById(R.id.t1Button)
        t1TextView = findViewById(R.id.t1TextView)

        t2Button = findViewById(R.id.t2Button)
        t2TextView = findViewById(R.id.t2TextView)

        t3Button = findViewById(R.id.t3Button)
        t3TextView = findViewById(R.id.t3TextView)

        t4Button = findViewById(R.id.t4Button)
        t4TextView = findViewById(R.id.t4TextView)


        t1Button.setOnClickListener {
            performTask1()
        }

        t2Button.setOnClickListener {
            performTask2(number = (Math.random() * 100).toInt())
        }

        t3Button.setOnClickListener {
            performTask3()
        }

        t4Button.setOnClickListener {
            performTask4()
        }

    }

    private fun performTask1() {
        t1Button.isEnabled = false
        val t1 = Thread {
            val a: Int = (Math.random() * 1000).toInt()
            val b: Int = (Math.random() * 1000).toInt()
            val c = a + b
            val result = "Result: $c"
            runOnUiThread {
                t1TextView.text = result
                t1Button.isEnabled = true
            }
        }

        t1.start()
    }

    private fun performTask2(number: Int) {
        t2Button.isEnabled = false
        var num = number

        val t2 = Thread {
            num++
            val result = "Result: $num"
            runOnUiThread {
                t2TextView.text = result
                t2Button.isEnabled = true
            }
        }

        val t1 = Thread {
            num /= 2
            t2.start()
        }

        t1.start()
    }


    private fun performTask3() {
        t3Button.isEnabled = false
        CounterUpdaterTask(
            onProgress = { counter ->
                val result = "Counter: $counter"
                t3TextView.text = result
            },
            onPostExecute = {
                t3Button.isEnabled = true
                Toast.makeText(this, "Task3 is done executing!", Toast.LENGTH_SHORT).show()
            }).execute(0)

    }

    private fun performTask4() {
        t4TextView.text = "Loading..."
        t4Button.isEnabled = false
        CoroutineScope(Dispatchers.Default).launch {
            val result = heavyComputationalTask()
            withContext(Dispatchers.Main) {
                t4TextView.text = "Result: $result"
                t4Button.isEnabled = true
            }
        }
    }


    private fun heavyComputationalTask(): Double {
        var t = 0.0
        for (i in (1..100000000)) {
            t = tan(i.toDouble())
        }
        return t
    }

}