package com.example.batuguntingkertas.ui.play

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ui.play.callback.Callback
import com.example.batuguntingkertas.ui.play.controller.Controller
import com.bumptech.glide.Glide

class VsPlayer : AppCompatActivity(), Callback {
    private lateinit var imageStatus: ImageView
    private lateinit var refresh: ImageView
    private lateinit var home: ImageView
    private lateinit var scorePemain: TextView
    private lateinit var scoreCpu: TextView
    private lateinit var scoreSeri: TextView
    private  lateinit var tvScoreMenang: TextView
    private lateinit var tvScoreSeri: TextView
    private lateinit var tvScoreKalah: TextView

    var scoreMenang = 0
    var scoreKalah = 0
    var scoreSama = 0

    var scoreDlgMenang = 0
    var scoreDlgKalah = 0
    var scoreDlgSama = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_player)

        imageStatus = findViewById(R.id.status)
        refresh = findViewById(R.id.refresh)
        val controller = Controller(this)
        home = findViewById(R.id.ivHome)
        scorePemain = findViewById(R.id.scorePemain)
        scoreCpu = findViewById(R.id.scoreCpu)
        scoreSeri = findViewById(R.id.scoreSeri)

        var player1 = 0
        var player2 = 0
        var klikPlayer1: Boolean = true
        var klikPlayer2: Boolean = true

        //Player 1
        val batu1 = findViewById<ImageView>(R.id.batu1)
        batu1.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                batu1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                batu1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player1 = 1
                klikPlayer1 = false
            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pemain 2 apa pilihanmu?", Toast.LENGTH_SHORT).show()
            }
        }
        val kt1 = findViewById<ImageView>(R.id.kt1)
        kt1.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                kt1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                kt1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player1 = 2
                klikPlayer1 = false
            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pemain 2 apa pilihanmu?", Toast.LENGTH_SHORT).show()
            }
        }
        val gt1 = findViewById<ImageView>(R.id.gt1)
        gt1.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                gt1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gunting))
                gt1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player1 = 3
                klikPlayer1 = false
            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pemain 2 apa pilihanmu?", Toast.LENGTH_SHORT).show()
            }
        }

        //player 2
        val batu2 = findViewById<ImageView>(R.id.batu2)
        batu2.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                Toast.makeText(this, "Player 1 apa pilihanmu?", Toast.LENGTH_SHORT).show()

            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                batu2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                batu2.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player2 = 1
                klikPlayer2 = false
                Toast.makeText(this, "Pemain 2 memilih batu", Toast.LENGTH_SHORT).show()
                controller.bandingkanNumbers(player1, player2)
            }
        }
        val kt2 = findViewById<ImageView>(R.id.kt2)
        kt2.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                Toast.makeText(this, "Player 1 apa pilihanmu?", Toast.LENGTH_SHORT).show()

            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                kt2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                kt2.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player2 = 2
                klikPlayer2 = false
                Toast.makeText(this, "Pemain 2 memilih kertas", Toast.LENGTH_SHORT).show()
                controller.bandingkanNumbers(player1, player2)
            }
        }
        val gt2 = findViewById<ImageView>(R.id.gt2)
        gt2.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                Toast.makeText(this, "Player 1 apa pilihanmu?", Toast.LENGTH_SHORT).show()

            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                gt2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gunting))
                gt2.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player2 = 3
                klikPlayer2 = false
                Toast.makeText(this, "Pemain 2 memilih gunting", Toast.LENGTH_SHORT).show()
                controller.bandingkanNumbers(player1, player2)
            }
        }

        refresh.setOnClickListener {
            batu1.background = (ContextCompat.getDrawable(this, R.drawable.batu))
            batu2.background = (ContextCompat.getDrawable(this, R.drawable.batu))
            kt1.background = (ContextCompat.getDrawable(this, R.drawable.kertas))
            kt2.background = (ContextCompat.getDrawable(this, R.drawable.kertas))
            gt1.background = (ContextCompat.getDrawable(this, R.drawable.gunting))
            gt2.background = (ContextCompat.getDrawable(this, R.drawable.gunting))
            imageStatus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vs))
            klikPlayer1 = true
            klikPlayer2 = true
        }

        // Permission Gilde
        val icon = findViewById<ImageView>(R.id.icon)
        Glide.with(this)
            .load("https://i.ibb.co/HC5ZPgD/splash-screen%201.png")
            .into(icon)

        home.setOnClickListener {
            finish()
        }
    }

    override fun kirimStatus(status: String) {
        scorePermainan(status)

        // Custom Dialog
        val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
        val alert = AlertDialog.Builder(this)
        alert.setView(view)
        alert.setCancelable(false)

        val dialog = alert.create()
        dialog.show()
        val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
        val name = intent.getStringExtra("Name")
        val hasilPemenang1 =
            if (status == "Player 1 Winner") {
                "$name \n Menang"
            } else {
                status
            }
        hasilPemenang.setText(hasilPemenang1);


        val btnOk = view.findViewById<ImageView>(R.id.ivReset)
        btnOk.setOnClickListener {
            dialog?.dismiss()
        }

        val btnMenu = view.findViewById<ImageView>(R.id.ivHome)
        btnMenu.setOnClickListener {
            finish()
        }

        tvScoreMenang = view.findViewById<TextView>(R.id.tvScoreMenang)
        tvScoreKalah = view.findViewById<TextView>(R.id.tvScoreKalah)
        tvScoreSeri = view.findViewById<TextView>(R.id.tvScoreSeri)

        scoreDialog(status)
    }
    fun scoreDialog(status: String) {
        when (status) {
            "Player 1 Winner" -> {
                scoreDlgMenang++
                tvScoreMenang.text = scoreDlgMenang.toString()

                var sharedPreferences = getSharedPreferences("sharePref", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putInt("SCORE",scoreDlgMenang)
                    .apply()
                val scr = getSharedPreferences("SCORE",0)
                //tvScoreMenang.text = scr.toString()
            }
            "Player 2 Winner" -> {
                scoreDlgKalah++
                tvScoreKalah.text = scoreDlgKalah.toString()

                var sharedPreferences = getSharedPreferences("sharePref", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putInt("SCORE",scoreDlgKalah)
                    .apply()
                val scr = getSharedPreferences("SCORE",0)
                //tvScoreKalah.text = scr.toString()


            }
            "Draw" -> {
                scoreDlgSama++
                tvScoreSeri.text = scoreDlgSama.toString()

                var sharedPreferences = getSharedPreferences("sharePref", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putInt("SCORE",scoreDlgSama)
                    .apply()
                val scr = getSharedPreferences("SCORE",0)
                // tvScoreSeri.text = scr.toString()
            }
        }
    }

    private fun scorePermainan(status: String) {
        when (status) {
            "Player 1 Winner" -> {
                scoreMenang++
                scorePemain.text = scoreMenang.toString()
            }
            "Player 2 Winner" -> {
                scoreKalah++
                scoreCpu.text = scoreKalah.toString()
            }
            "Draw" -> {
                scoreSama++
                scoreSeri.text = scoreSama.toString()
            }
        }
    }
}
