package com.introduccion.tarea4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_resultactivity)

        val number = intent.getIntExtra("number", 0)
        val fibonacciNumber = calculateFibonacci(number)

        val resultTextView : TextView = findViewById(R.id.result_text_view)
        resultTextView.text = "Fibonacci de $number es $fibonacciNumber"

        val backButton: Button = findViewById(R.id.button_back)
        backButton.setOnClickListener {
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun calculateFibonacci(n: Int): Int {
        return if (n <= 1) {
            n
        } else {
            calculateFibonacci(n-1) + calculateFibonacci(n-2)
        }
    }
}