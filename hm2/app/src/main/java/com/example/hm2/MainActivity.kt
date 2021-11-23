package com.example.hm2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var btnWhile: Button
    lateinit var btnFor: Button

    var array = arrayListOf("A", "B", "C", "D", "E")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView - связывание kt и xml файла
        setContentView(R.layout.activity_main)
        editText =  findViewById(R.id.editText)
        btnWhile = findViewById(R.id.btnWhile)
        btnFor = findViewById(R.id.btnFor)

        btnWhile.setOnClickListener() {
            val text = editText.text.toString()
            val result = getValueUsingWhile(text)
            val intent = Intent(this, ResultActivity::class.java)

            if(text.trim().isEmpty()) {
                Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show()
            }
            else {
                intent.putExtra("result", result)
                startActivity(intent)
            }
        }

        btnFor.setOnClickListener() {
            val text = editText.text.toString()
            val result = getValueUsingFor(text)
        }
    }

    fun getValueUsingWhile(text: String): String? {

        var index = 0

        while (index < array.size) {
            if(text == array[index]) {
                return "$text : $index"
            }
            ++index
        }
        return null
    }

    fun getValueUsingFor(text: String) {

        for (i in array) {
            if(i == text) {
                var intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("TEXT", text)
                intent.putExtra("INDEX", array.indexOf(i))
                startActivity(intent)
            }
            else if (text.isNullOrEmpty()) Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show()
        }
    }
}