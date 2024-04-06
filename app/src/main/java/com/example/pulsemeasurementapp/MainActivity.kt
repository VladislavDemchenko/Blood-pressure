package com.example.pulsemeasurementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var variable
        // val constant


        val firstNumberPicker = findViewById<NumberPicker>(R.id.firstNumberPicker)
        firstNumberPicker.minValue = 50
        firstNumberPicker.maxValue = 250
        firstNumberPicker.value = 120


        val secondNumberPicker = findViewById<NumberPicker>(R.id.secondNumberPicker)
        secondNumberPicker.minValue = 0
        secondNumberPicker.maxValue = 100
        secondNumberPicker.value = 5

        val thirdNumberPicker = findViewById<NumberPicker>(R.id.thirdNumberPicker)
        thirdNumberPicker.minValue = 0
        thirdNumberPicker.maxValue = 100
        thirdNumberPicker.value = 5

        firstNumberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            val db = DatabaseHelper(this)
            db.
        }

        // Отримання обраного значення
        val selectedValue = firstNumberPicker.value
        // Ви можете використовувати це обране значення для подальшої обробки
    }
}