package com.example.pulsemeasurementapp;

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pulsemeasurementapp.model.BloodPressureData

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 16) {

    companion object {
        private const val DATABASE_NAME = "MyDatabase.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE bloodPressure (id INTEGER PRIMARY KEY, systolic INTEGER, diastolic INTEGER, pulse INTEGER)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS bloodPressure")
        onCreate(db)
    }

    fun insertValues(value: BloodPressureData) {
        val contentValues = ContentValues()
        contentValues.put("systolic", value.systolic)
        contentValues.put("diastolic", value.diastolic)
        contentValues.put("pulse", value.pulse)

        val db = this.writableDatabase
        db.insert("bloodPressure", null, contentValues)

        db.close()
    }

//    fun getAllBloodPressure(): List<BloodPressureData> {
//        val bloodPressureList = mutableListOf<BloodPressureData>()
//        val db = this.readableDatabase
//        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
//
//        if (cursor.moveToFirst()) {
//            do {
//                val systolic = cursor.getInt(cursor.getColumnIndex("systolic"))
//                val diastolic = cursor.getInt(cursor.getColumnIndex("diastolic"))
//                val pulse = cursor.getInt(cursor.getColumnIndex(COLUMN_PULSE))
//
//                val bloodPressureData = BloodPressureData(systolic, diastolic, pulse)
//                bloodPressureList.add(bloodPressureData)
//            } while (cursor.moveToNext())
//        }
//
//        cursor.close()
//        db.close()
//
//        return bloodPressureList
//    }
}

