package com.introduccion.tarea4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_mainactivity)

        val inputNumber: EditText = findViewById((R.id.input_number))
        val calculateButton: EditText = findViewById((R.id.calculate_button))

        calculateButton.setOnClickListener {
            val number = inputNumber.text.toString().toIntOrNull()
            if (number != null && number in 1 .. 10000) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("number", number)
                startActivity(intent)
            } else {
                inputNumber.error = "Por favor ingrese un numero valido entre el 1 y el 10000"
            }
        }
    }
}