package com.hmman.asyncawaitcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val data1 = async { getData1() }
            val data2 = async { getData2() }
            val total = data1.await() + data2.await()

            Log.i("getData", "data:  $total")
        }

    }

    private suspend fun getData1(): Int {
        delay(10000)
        Log.i("getData", "getData1 returned")
        return 10
    }

    private suspend fun getData2(): Int {
        delay(12000)
        Log.i("getData", "getData2 returned")
        return 12
    }
}
