package com.lalan.android_learning.workmanager

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lalan.android_learning.R

class WorkManagerLearning : AppCompatActivity() {

    private lateinit var textview1: TextView
    private lateinit var textview2: TextView
    private lateinit var runFabButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_work_manager_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textview1 = findViewById(R.id.textview1)
        textview2 = findViewById(R.id.textview2)
        runFabButton = findViewById(R.id.runFabButton)

        runFabButton.setOnClickListener {

            val nonConstrainWorker = OneTimeWorkRequest
                .Builder(MyNonConstraintWorker::class.java)
                .build()

            val constraintWorker = OneTimeWorkRequest
                .Builder(MyConstraintWorker::class.java)
                .setConstraints(
                    Constraints(
                        requiresCharging = true,
                        requiredNetworkType = NetworkType.CONNECTED
                    )
                )
                .build()

            WorkManager.getInstance(this).enqueue(nonConstrainWorker)
            WorkManager.getInstance(this).enqueue(constraintWorker)

            WorkManager.getInstance(this).getWorkInfoByIdLiveData(nonConstrainWorker.id)
                .observe(this) { workInfo ->
                    if (workInfo == null)
                        return@observe

                    val status = "Non-Constraint Worker: ${workInfo.state}"
                    textview1.text = status
                }

            WorkManager.getInstance(this).getWorkInfoByIdLiveData(constraintWorker.id)
                .observe(this) { workInfo ->
                    if (workInfo == null)
                        return@observe

                    val status = "Constraint Worker: ${workInfo.state}"
                    textview2.text = status
                }
        }
    }
}


