package com.lalan.android_learning.viewmodel_livedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountdownViewModel : ViewModel() {

    private val _timer = MutableLiveData<Int>().apply { value = 10 }
    private val _isTimerRunning = MutableLiveData<Boolean>().apply { value = false }

    val timer: LiveData<Int> get() = _timer
    val isTimerRunning: LiveData<Boolean> get() = _isTimerRunning

    private var timerJob: Job? = null

    fun startTimer(newTimer: Int) {
        _isTimerRunning.postValue(true)
        timerJob = viewModelScope.launch {
            for (i in newTimer downTo 0) {
                _timer.postValue(i)
                delay(999)
            }
            _isTimerRunning.postValue(false)
        }
    }

    fun stopTimer() {
        _isTimerRunning.postValue(false)
        timerJob?.cancel()
    }
}