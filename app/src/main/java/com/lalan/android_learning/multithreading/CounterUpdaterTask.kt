package com.lalan.android_learning.multithreading

import android.os.AsyncTask

class CounterUpdaterTask(val onProgress: (Int) -> Unit, val onPostExecute: () -> Unit) :
    AsyncTask<Int, Int, Int>() {

    override fun doInBackground(vararg input: Int?): Int {
        for (i in (1..100)) {
            publishProgress(i)
            Thread.sleep(100)
        }
        return -1
    }

    override fun onProgressUpdate(vararg values: Int?) {
        if (values[0] == 10) {
            cancel(true)
            onPostExecute(values[0])
        }
        onProgress(values[0] ?: 0)
    }

    override fun onPostExecute(result: Int?) {
        onPostExecute()
    }
}