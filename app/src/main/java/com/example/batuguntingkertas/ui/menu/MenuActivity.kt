package com.example.batuguntingkertas.ui.menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.database.FriendsEntity
import com.example.batuguntingkertas.ui.chatBotActivity.ChatBotActivity
import com.example.batuguntingkertas.ui.menu.Friends.FriendsActivity
import com.example.batuguntingkertas.ui.play.VsCpu
import com.example.batuguntingkertas.ui.play.VsPlayer
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val play = findViewById<Button>(R.id.btnPlay)
        val multiPlayer = findViewById<Button>(R.id.btnMulti)
        val Friends = findViewById<Button>(R.id.btnFriends)
        val exit = findViewById<Button>(R.id.btnExit)
        val chat = findViewById<FloatingActionButton>(R.id.fabChat)

        play.setOnClickListener { startActivity(Intent(this, VsCpu::class.java)) }
        multiPlayer.setOnClickListener { startActivity(Intent(this, VsPlayer::class.java)) }
        Friends.setOnClickListener { startActivity(Intent(this, FriendsActivity::class.java)) }
        exit.setOnClickListener { System.exit(-1) }
        chat.setOnClickListener { startActivity(Intent(this, ChatBotActivity::class.java)) }

    }

}