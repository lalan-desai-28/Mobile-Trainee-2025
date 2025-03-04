package com.lalan.android_learning.dependency_injection.task_two.module

import android.util.Log
import javax.inject.Inject


class Patient @Inject constructor() {

    val name: String = "Walter White"

    init {
        Log.d("TAG", "Patient: Patient has been initialized.")
    }
}