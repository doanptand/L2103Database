package com.ddona.database.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StudentDbHelper(context: Context) :
    SQLiteOpenHelper(context, "student.db", null, 1) {

    companion object {
        const val TABLE_NAME = "student"
        const val COL_ID = "_id"
        const val COL_NAME = "_name"
        const val COL_CLASS_NAME = "_class"
        val CREATE_STUDENT_TABLE =
            "CREATE TABLE $TABLE_NAME($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT, $COL_CLASS_NAME TEXT)"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_STUDENT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldV: Int, newV: Int) {
    }
}