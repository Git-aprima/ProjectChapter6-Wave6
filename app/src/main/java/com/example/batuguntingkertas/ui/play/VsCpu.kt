package com.example.batuguntingkertas.ui.play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R
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
    var Nama: String? = null

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


        val controller = Controller(this)

        val btn = mutableListOf(batu1, kt1, gt1)
        var klik: Boolean = true

        repeat(btn.size) {
            batu1.setOnClickListener {
                val indext = (0..2).random()
                if (klik) {
                    batu1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                    batu1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                    klik = false

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
        }

        home.setOnClickListener {
            finish()
        }


        pemain = findViewById<TextView>(R.id.pemain)
        if (getIntent().getStringExtra("Name") != null) {
            Nama = getIntent().getStringExtra("Name");
            pemain.setText(Nama);
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
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p1menang
                    )
                )

                // Custom Dialog
                val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()
                val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
                val name = intent.getStringExtra("Name")
                hasilPemenang.setText(name + "\n MENANG!");

              /*
                val tvScoreMenang = view.findViewById<TextView>(R.id.tvScoreMenang)*/


                val btnOk = view.findViewById<ImageView>(R.id.ivReset)


                btnOk.setOnClickListener {
                    dialog?.dismiss()
                }

                val btnMenu = view.findViewById<ImageView>(R.id.ivHome)
                btnMenu.setOnClickListener {
                    finish()
                }
            }


            status.contains("2") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p2menang
                    )
                )

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
                hasilPemenang.setText(name + "\n MENANG!");


                val btnOk = view.findViewById<ImageView>(R.id.ivReset)

                btnOk.setOnClickListener {
                    dialog?.dismiss()
                }

                val btnMenu = view.findViewById<ImageView>(R.id.ivHome)
                btnMenu.setOnClickListener {
                    finish()
                }


            }
            status.contains("w") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.draw
                    )
                )

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
                hasilPemenang.setText(name);


                val btnOk = view.findViewById<ImageView>(R.id.ivReset)


                btnOk.setOnClickListener {
                    dialog?.dismiss()
                }

                val btnMenu = view.findViewById<ImageView>(R.id.ivHome)
                btnMenu.setOnClickListener {
                    finish()
                }
            }
        }
    }


}