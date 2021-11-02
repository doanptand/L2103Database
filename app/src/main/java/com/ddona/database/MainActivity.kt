package com.ddona.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddona.database.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefers = getSharedPreferences("account", MODE_PRIVATE)
        val savedAccount: String = prefers.getString("account", "")!!
        val savedPassword: String = prefers.getString("password", "")!!
        if (savedAccount.isNotEmpty() && savedPassword.isNotEmpty()) {
            val welcomeIntent = Intent(this, WelcomeActivity::class.java)
            startActivity(welcomeIntent)
            return
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val account = binding.edtAccount.text.toString()
            val password = binding.edtPassword.text.toString()
            if (account == "doanpt" && password == "123") {
                val editor = prefers.edit()
                editor.putString("account", account)
                editor.putString("password", password)
                editor.apply()
                val welcomeIntent = Intent(this, WelcomeActivity::class.java)
                startActivity(welcomeIntent)
            }
        }
    }
}