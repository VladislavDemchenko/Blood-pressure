package com.example.pulsemeasurementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.pulsemeasurementapp.model.BloodPressureData
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, HistoryPage::class.java)
//        arrow back
        val arrowButton = findViewById<ImageButton>(R.id.arrowButton)
        arrowButton.setOnClickListener{
            startActivity(intent)
        }


        val firstNumberPicker = findViewById<NumberPicker>(R.id.firstNumberPicker)
        firstNumberPicker.minValue = 50
        firstNumberPicker.maxValue = 250
        firstNumberPicker.value = 120


        val secondNumberPicker = findViewById<NumberPicker>(R.id.secondNumberPicker)
        secondNumberPicker.minValue = 0
        secondNumberPicker.maxValue = 100
        secondNumberPicker.value = 50

        val thirdNumberPicker = findViewById<NumberPicker>(R.id.thirdNumberPicker)
        thirdNumberPicker.minValue = 0
        thirdNumberPicker.maxValue = 100
        thirdNumberPicker.value = 50

        val currentDateButton: Button = findViewById(R.id.currentDateButton)
        val currentTimeButton: Button = findViewById(R.id.currentTimeButton)



        // Встановлюємо текучу дату в форматі "dd/MM/yyyy" в текст кнопки currentDateButton
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        currentDateButton.text = currentDate

        // Встановлюємо текучий час в форматі "HH:mm:ss" в текст кнопки currentTimeButton
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        currentTimeButton.text = currentTime



        //button save
        val button: Button = findViewById(R.id.button)

        //logic button save
        button.setOnClickListener{
            val db = DatabaseHelper(this)
            db.insertValues(BloodPressureData(firstNumberPicker.value, secondNumberPicker.value, thirdNumberPicker.value))
            startActivity(intent)
        }
    }
}