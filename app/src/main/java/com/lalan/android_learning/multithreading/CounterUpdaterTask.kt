package com.lalan.android_learning.multithreading

import android.os.AsyncTask

class CounterUpdaterTask(val onProgress: (Int) -> Unit, val onPostExecute: () -> Unit) :
    AsyncTask<Int, Int, Int>() {

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg input: Int?): Int {
        for (i in (1..100)) {
            publishProgress(i)
            Thread.sleep(100)
        }
        return -1
    }

    @Deprecated("Deprecated in Java")
    override fun onProgressUpdate(vararg values: Int?) {
        if (values[0] == 10) {
            cancel(true)
            onPostExecute(values[0])
        }
        onProgress(values[0] ?: 0)
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Int?) {
        onPostExecute()
    }
}