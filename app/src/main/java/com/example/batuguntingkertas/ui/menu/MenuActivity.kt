package com.example.batuguntingkertas.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
/*
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

 */
import com.example.batuguntingkertas.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val navController = findNavController(R.id.fragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnvMain)
        bottomNavigationView.setupWithNavController(navController)
    }

}