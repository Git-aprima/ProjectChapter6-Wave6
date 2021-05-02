package com.example.batuguntingkertas.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.database.DbUser
import com.example.batuguntingkertas.data.datalokal.SharedPreferences
import com.example.batuguntingkertas.ui.MainActivity
import com.example.batuguntingkertas.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity(), LoginNavigator {

    private lateinit var etUserName: EditText
    private lateinit var etUserPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var btnLoginDua: Button
    private lateinit var ivJudul: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUserName = findViewById(R.id.etUsername)
        etUserPassword = findViewById(R.id.etUserPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        btnLoginDua = findViewById(R.id.btnLoginDua)
        ivJudul = findViewById(R.id.ivJudulLogin)
        val login = LoginPresenter(this, this)
        val pref = SharedPreferences (this)

        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(ivJudul)

        btnLoginDua.setOnClickListener {
            if (etUserName.text.toString().isEmpty()){
                etUserPassword.error= "Username Belum Diisi"
            }else if (etUserPassword.text.toString().isEmpty()){
                etUserPassword.error = "Password harus Diisi"
            } else {
            val nama = etUserName.text.toString()
            val password = etUserPassword.text.toString()
            login.login(nama, password)
                pref.username = nama
                pref.sandi = password
                pref.isLogin= true
            }
        }

        btnSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }

    override fun errorLogin() {
        Toast.makeText(this, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show()
    }

    override fun succesLogin() {

        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

    }
}