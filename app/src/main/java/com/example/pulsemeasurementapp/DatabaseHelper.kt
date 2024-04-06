package com.example.pulsemeasurementapp;

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pulsemeasurementapp.model.BloodPressureData

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MyDatabase.db"
        private const val TABLE_NAME = "bloodPressure"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (id INTEGER PRIMARY KEY, systolic INTEGER, diastolic INTEGER, pulse INTEGER)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertValues(value: BloodPressureData) {
        val contentValues = ContentValues()
        contentValues.put("systolic", value.systolic)
        contentValues.put("diastolic", value.diastolic)
        contentValues.put("pulse", value.pulse)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, contentValues)

        db.close()
    }
//
//    @SuppressLint("Range")
//    fun getSelectedValue(): Int {
//        val db = this.readableDatabase
//        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
//        var selectedValue = 0
//        if (cursor.moveToFirst()) {
//            selectedValue = cursor.getInt(cursor.getColumnIndex(COLUMN_VALUE))
//        }
//        cursor.close()
//        db.close()
//        return selectedValue
//    }
}

