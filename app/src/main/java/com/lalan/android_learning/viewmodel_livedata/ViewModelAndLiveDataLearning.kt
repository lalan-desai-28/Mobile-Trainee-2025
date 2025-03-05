package com.lalan.android_learning.viewmodel_livedata

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.lalan.android_learning.R
import com.lalan.android_learning.viewmodel_livedata.viewmodel.CountdownViewModel

class ViewModelAndLiveDataLearning : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var timerEditText: EditText
    private lateinit var playPauseImageButton: ImageButton
    private lateinit var countdownViewModel: CountdownViewModel

    private fun startTimer() {
        val newTimerSeconds: Int
        try {
            newTimerSeconds = timerEditText.text.toString().toInt()
        } catch (ex: Exception) {
            Toast.makeText(this, "Invalid timer seconds!", Toast.LENGTH_SHORT).show()
            return
        }

        if (newTimerSeconds == 0) return Toast.makeText(
            this,
            "Timer cannot set to zero.",
            Toast.LENGTH_SHORT
        ).show()

        countdownViewModel.startTimer(newTimerSeconds)
        progressBar.max = newTimerSeconds
    }

    private fun stopTimer() {
        playPauseImageButton.setImageDrawable(getDrawable(R.drawable.play_arrow_24px))
        countdownViewModel.stopTimer()
        timerEditText.isEnabled = true
    }


    private fun onTick(time: Int) {
        timerEditText.setText(time.toString())
        progressBar.progress = time
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_model_and_live_data_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        progressBar = findViewById(R.id.progressBar)
        timerEditText = findViewById(R.id.timerEditText)
        playPauseImageButton = findViewById(R.id.playPauseImageButton)
        countdownViewModel = ViewModelProvider(this)[CountdownViewModel::class.java]


        playPauseImageButton.setOnClickListener {
            if (countdownViewModel.isTimerRunning.value == false) startTimer() else stopTimer()
        }

        countdownViewModel.timer.observe(this as LifecycleOwner) { timer ->
            if (timer != null) onTick(timer)
        }

        countdownViewModel.isTimerRunning.observe(this as LifecycleOwner) { isTimerRunning ->
            timerEditText.isEnabled = !isTimerRunning
            playPauseImageButton.setImageDrawable(
                AppCompatResources.getDrawable(
                    this,
                    if (isTimerRunning) R.drawable.pause_24px else R.drawable.play_arrow_24px
                )
            )
        }

    }
}