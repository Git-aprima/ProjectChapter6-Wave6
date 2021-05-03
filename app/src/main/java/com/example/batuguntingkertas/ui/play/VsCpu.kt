package com.example.batuguntingkertas.ui.play

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ui.menu.MenuActivity
import com.example.batuguntingkertas.ui.play.callback.Callback
import com.example.batuguntingkertas.ui.play.controller.Controller

class VsCpu : AppCompatActivity(), Callback {
    private lateinit var imageStatus: ImageView
    private lateinit var batu1: ImageView
    private lateinit var kt1: ImageView
    private lateinit var gt1: ImageView
    private lateinit var batu2: ImageView
    private lateinit var kt2: ImageView
    private lateinit var gt2: ImageView
    private lateinit var refresh: ImageView
    private lateinit var pemain: TextView
    private lateinit var home: ImageView
    private lateinit var tvTimer: TextView
    private var Nama: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_cpu)

        batu1 = findViewById(R.id.batu1)
        batu2 = findViewById(R.id.batu2)
        kt1 = findViewById(R.id.kt1)
        kt2 = findViewById(R.id.kt2)
        gt1 = findViewById(R.id.gt1)
        gt2 = findViewById(R.id.gt2)
        refresh = findViewById(R.id.refresh)
        imageStatus = findViewById(R.id.status)
        home = findViewById(R.id.ivHome)
        tvTimer = findViewById(R.id.tvTimer)

        val timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = (millisUntilFinished % 60000) / 1000
                val seconds = (secondsRemaining)
                val timerText = "$seconds"
                tvTimer.text = timerText
            }


        override fun onFinish() {
            tvTimer.text = "0"
            val view = LayoutInflater.from(this@VsCpu).inflate(R.layout.dialog_timer, null, false)
            val alert = AlertDialog.Builder(this@VsCpu)
            alert.setView(view)
            alert.setCancelable(false)

            val dialog = alert.create()
            dialog.show()

            val name = intent.getStringExtra("Name")


            val btnMain = view.findViewById<Button>(R.id.btnMain)
            btnMain.setOnClickListener {
                val intent = Intent(this@VsCpu, VsCpu::class.java)
                intent.putExtra("Name", name.toString())
                startActivity(intent)
            }

            val btnKembali = view.findViewById<Button>(R.id.btnKembali)
            btnKembali.setOnClickListener {
                val intent = Intent(this@VsCpu, MenuActivity::class.java)
                intent.putExtra("Name", name.toString())
                startActivity(intent)
            }

            }
        }

        timer.start()

        val controller = Controller(this)

        val btn = mutableListOf(batu1, kt1, gt1)
        var klik = true

        repeat(btn.size) {
            batu1.setOnClickListener {
                val indext = (0..2).random()
                if (klik) {
                    batu1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                    batu1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                    klik = false
                    timer.cancel()

                    when (indext) {
                        0 -> {
                            batu2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                            batu2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih batu", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(0, 0)
                        }
                        1 -> {
                            kt2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                            kt2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih kertas", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(0, 1)
                        }
                        2 -> {
                            gt2.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.gunting
                                )
                            )
                            gt2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih gunting", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(2, 1)
                        }

                    }


                } else {
                    Toast.makeText(this, "Harap Reset Dahulu", Toast.LENGTH_LONG).show()
                }

            }

            kt1.setOnClickListener {
                val indext = (0..2).random()
                if (klik) {
                    kt1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                    kt1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                    klik = false
                    timer.cancel()

                    when (indext) {
                        0 -> {
                            batu2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                            batu2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih batu", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(1, 0)
                        }
                        1 -> {
                            kt2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                            kt2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih kertas", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(1, 1)
                        }
                        2 -> {
                            gt2.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.gunting
                                )
                            )
                            gt2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih gunting", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(1, 2)
                        }
                    }

                } else {
                    Toast.makeText(this, "Harap Reset Dahulu", Toast.LENGTH_LONG).show()
                }

            }

            gt1.setOnClickListener {
                val indext = (0..2).random()
                if (klik) {
                    gt1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gunting))
                    gt1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                    klik = false
                    timer.cancel()

                    when (indext) {
                        0 -> {
                            batu2.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.select
                                )
                            )
                            Toast.makeText(this, "CPU Memilih batu", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(0, 2)
                        }
                        1 -> {
                            kt2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                            kt2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih kertas", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(2, 1)
                        }
                        2 -> {
                            gt2.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.gunting
                                )
                            )
                            gt2.background =
                                (ContextCompat.getDrawable(this, R.drawable.select))
                            Toast.makeText(this, "CPU Memilih gunting", Toast.LENGTH_SHORT).show()
                            controller.bandingkanNumbers(2, 2)
                        }
                    }
                } else {
                    Toast.makeText(this, "Harap Reset Dahulu", Toast.LENGTH_LONG).show()
                }
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
            klik = true
            timer.cancel()
            timer.onTick(30000)
            timer.start()
        }

        home.setOnClickListener {
            finish()
        }


        pemain = findViewById(R.id.pemain)
        if (intent.getStringExtra("Name") != null) {
            Nama = intent.getStringExtra("Name")
            pemain.text = Nama
        }

        // Permission Gilde
        val icon = findViewById<ImageView>(R.id.icon)
        Glide.with(this)
            .load("https://i.ibb.co/HC5ZPgD/splash-screen%201.png")
            .into(icon)
    }


    override fun kirimStatus(status: String) {
        when {
            status.contains("1") -> {
                imageStatus.setImageResource(R.drawable.p1menang)

                // Custom Dialog
                val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()
                val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
                val name = intent.getStringExtra("Name")
                hasilPemenang.text = name + "\n MENANG!"


                val btnOk = view.findViewById<ImageView>(R.id.ivReset)


                btnOk.setOnClickListener {
                    dialog.dismiss()

                }

                val btnMenu = view.findViewById<ImageView>(R.id.ivHome)
                btnMenu.setOnClickListener {
                    finish()
                }
            }


            status.contains("2") -> {
                imageStatus.setImageResource(R.drawable.p2menang)
                // Custom Dialog
                val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()

                val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
                intent.putExtra("cpu", "CPU")
                val name = intent.getStringExtra("cpu")
                hasilPemenang.text = "$name\n MENANG!"


                val btnOk = view.findViewById<ImageView>(R.id.ivReset)

                btnOk.setOnClickListener {
                    dialog.dismiss()
                }

                val btnMenu = view.findViewById<ImageView>(R.id.ivHome)
                btnMenu.setOnClickListener {
                    finish()
                }


            }
            status.contains("w") -> {
                imageStatus.setImageResource(R.drawable.draw)
                // Custom Dialog
                val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()

                val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
                intent.putExtra("seri", "SERI!")
                val name = intent.getStringExtra("seri")
                hasilPemenang.text = name


                val btnOk = view.findViewById<ImageView>(R.id.ivReset)


                btnOk.setOnClickListener {
                    dialog.dismiss()
                }

                val btnMenu = view.findViewById<ImageView>(R.id.ivHome)
                btnMenu.setOnClickListener {
                    finish()
                }
            }
        }
    }


}