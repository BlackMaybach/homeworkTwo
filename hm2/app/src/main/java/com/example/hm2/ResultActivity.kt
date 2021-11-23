package com.example.hm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    lateinit var showWhile: TextView

    lateinit var showFor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        showWhile = findViewById(R.id.getValueUsingWhile)
        showFor = findViewById(R.id.getValueUsingFor)

        // получение getExtra() данных
        val getWhile = intent.getStringExtra("result")
        val getForText = intent.getStringExtra("TEXT")
        val getForIndex = intent.getIntExtra("INDEX", 0)

        showWhile.text = getWhile
        showFor.text = "$getForText : $getForIndex"

    }
}