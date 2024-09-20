package com.example.mobile_lab3

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val butt: Button = findViewById(R.id.button)
        val input: TextInputEditText = findViewById(R.id.textInputEditText)
        val numbers = listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')

        butt.setOnClickListener {
            var i = 0
            var text = input.text.toString().toCharArray()
            for (char in text){
                if (!(char in numbers)) i += 1
            }
            Toast.makeText(this@MainActivity, "Количество не-цифр: ${i}", LENGTH_SHORT).show()
        }
    }
}