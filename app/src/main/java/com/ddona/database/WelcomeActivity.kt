package com.ddona.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddona.database.databinding.ActivityWelcomeBinding
import com.ddona.database.manager.StudentManager
import com.ddona.database.model.Student

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var studentManager: StudentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentManager = StudentManager(this)

        binding.btnAdd.setOnClickListener {
            val name = binding.edtName.text.toString()
            val className = binding.edtClassName.text.toString()
            studentManager.addStudent2(Student(name = name, className = className))
        }
        binding.btnDelete.setOnClickListener {
            val id = binding.edtId.text.toString()
            studentManager.deleteStudentById(id)
        }
        binding.btnEdit.setOnClickListener {
            val id = binding.edtId.text.toString()
            val name = binding.edtName.text.toString()
            val className = binding.edtClassName.text.toString()
            studentManager.updateStudent(Student(id, name, className))
        }
        studentManager.getAllStudent()

    }
}