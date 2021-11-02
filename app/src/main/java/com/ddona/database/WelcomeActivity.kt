package com.ddona.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val prefers = getSharedPreferences("account", MODE_PRIVATE)
        val savedAccount: String = prefers.getString("account", "")!!
        val savedPassword: String = prefers.getString("password", "")!!
        Toast.makeText(this, "$savedAccount - $savedPassword", Toast.LENGTH_SHORT).show()
    }
}