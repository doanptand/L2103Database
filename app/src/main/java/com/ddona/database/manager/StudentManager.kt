package com.ddona.database.manager

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.ddona.database.db.StudentDbHelper
import com.ddona.database.model.Student

class StudentManager(context: Context) {
    private var studentDbHelper = StudentDbHelper(context)
    private val db: SQLiteDatabase = studentDbHelper.writableDatabase


    fun addStudent(student: Student) {
//        val q =
//            "INSERT INTO student(_name, _class_name) values('" + student.name + "','" + student.className + "';"
        val query =
            "INSERT INTO ${StudentDbHelper.TABLE_NAME}(${StudentDbHelper.COL_NAME}, ${StudentDbHelper.COL_CLASS_NAME}) values('${student.name}', '${student.className}')"
        db.execSQL(query)
    }

    fun addStudent2(student: Student) {
        val values = ContentValues()
        values.put(StudentDbHelper.COL_NAME, student.name)
        values.put(StudentDbHelper.COL_CLASS_NAME, student.className)
        db.insert(StudentDbHelper.TABLE_NAME, null, values)
    }

    //Tim
    fun getAllStudent(): List<Student> {
        val query = "SELECT * FROM ${StudentDbHelper.TABLE_NAME}"
        val students = arrayListOf<Student>()

        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            //doc data
            //vao dc 1 dong
            val idIndex = cursor.getColumnIndex(StudentDbHelper.COL_ID)
            val nameIndex = cursor.getColumnIndex(StudentDbHelper.COL_NAME)
            val classNameIndex = cursor.getColumnIndex(StudentDbHelper.COL_CLASS_NAME)
            do {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)
                val className = cursor.getString(classNameIndex)
                students.add(Student(id, name, className))
            } while (cursor.moveToNext())
        }
        return students
    }

    fun getAllStudents(): List<Student> {
        val cursor = db.query(StudentDbHelper.TABLE_NAME, null, null, null, null, null, null)
        val students = arrayListOf<Student>()
        if (cursor.moveToFirst()) {
            //doc data
            //vao dc 1 dong
            val idIndex = cursor.getColumnIndex(StudentDbHelper.COL_ID)
            val nameIndex = cursor.getColumnIndex(StudentDbHelper.COL_NAME)
            val classNameIndex = cursor.getColumnIndex(StudentDbHelper.COL_CLASS_NAME)
            do {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)
                val className = cursor.getString(classNameIndex)
                students.add(Student(id, name, className))
            } while (cursor.moveToNext())
        }
        return students
    }

    fun updateStudent(student: Student) {
        val values = ContentValues()
        values.put(StudentDbHelper.COL_NAME, student.name)
        values.put(StudentDbHelper.COL_CLASS_NAME, student.className)
//        db.update(
//            StudentDbHelper.TABLE_NAME,
//            values,
//            "${StudentDbHelper.COL_ID}=${student.id} AND ${StudentDbHelper.COL_CLASS_NAME}='L2103'",
//            null
//        )
        db.update(
            StudentDbHelper.TABLE_NAME,
            values,
            "${StudentDbHelper.COL_ID}=?",
            arrayOf("${student.id}")
        )
    }

    fun deleteStudentById(id: Int) {
        db.delete(
            StudentDbHelper.TABLE_NAME,
            "${StudentDbHelper.COL_ID}=?",
            arrayOf("$id")
        )
    }

    fun getAllStudentById(sID: Int): List<Student> {
        val query =
            "SELECT * FROM ${StudentDbHelper.TABLE_NAME} WHERE ${StudentDbHelper.COL_ID} = $sID"
        val students = arrayListOf<Student>()

        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            //doc data
            //vao dc 1 dong
            val idIndex = cursor.getColumnIndex(StudentDbHelper.COL_ID)
            val nameIndex = cursor.getColumnIndex(StudentDbHelper.COL_NAME)
            val classNameIndex = cursor.getColumnIndex(StudentDbHelper.COL_CLASS_NAME)
            do {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)
                val className = cursor.getString(classNameIndex)
                students.add(Student(id, name, className))
            } while (cursor.moveToNext())
        }
        return students
    }

}