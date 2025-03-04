package com.lalan.android_learning.dependency_injection.task_two.module

import android.util.Log
import javax.inject.Inject

class Doctor @Inject constructor(
    val patient: Patient
) {
    init {
        Log.d("TAG", "Doctors: Doctor has been initialized. and patient's name is ${patient.name}")
    }
}