package com.example.batuguntingkertas.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ui.chatBotActivity.ChatBotActivity
import com.example.batuguntingkertas.ui.play.VsPlayer
import com.example.batuguntingkertas.ui.play.VsCpu
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val play = view.findViewById<Button>(R.id.btnPlay)
        val multiPlayer = view.findViewById<Button>(R.id.btnMulti)
        val setting = view.findViewById<Button>(R.id.btnSetting)
        val exit = view.findViewById<Button>(R.id.btnExit)
        val chat = view.findViewById<FloatingActionButton>(R.id.fabChat)

        play.setOnClickListener { startActivity(Intent(activity, VsCpu::class.java)) }
        multiPlayer.setOnClickListener { startActivity(Intent(activity, VsPlayer::class.java)) }
        setting.setOnClickListener { }
        exit.setOnClickListener { System.exit(-1) }
        chat.setOnClickListener { startActivity(Intent(activity, ChatBotActivity::class.java)) }
    }
}