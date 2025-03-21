package com.example.coroutines_asyncawait

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
            Log.i("MyTag", "Calculation started")
            val s1 = async(IO) { getStock1() }
            val s2 = async(IO) { getStock2() }
            val total = s1.await() + s2.await()
            Toast.makeText(applicationContext, "Total is $total", Toast.LENGTH_LONG).show()
            Log.i("MyTag", "Total is $total")
        }
    }
}

private suspend fun getStock1() : Int {
    delay(10000)
    Log.i("MyTag", "Stock 1 returned")
    return 55000
}

private suspend fun getStock2() : Int {
    delay(8000)
    Log.i("MyTag", "Stock 2 returned")
    return 35000
}