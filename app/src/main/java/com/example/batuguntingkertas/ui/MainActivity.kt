package com.example.batuguntingkertas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.datalokal.SharedPreferences
import com.example.batuguntingkertas.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = SharedPreferences(this)
        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            pref.isLogin=false
            finish()
        }
    }
}