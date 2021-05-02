package com.example.batuguntingkertas.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.database.DbUser
import com.example.batuguntingkertas.ui.menu.MenuActivity
import com.example.batuguntingkertas.ui.register.RegisterActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(ivJudul)

        //Tanpa Pattern MVP dulu
        val mDb = DbUser.getInstance(this)

        btnSignUp.setOnClickListener {
            GlobalScope.launch {
                val user = mDb?.userDao()
                    ?.getUser(etUserName.text.toString(), etUserPassword.text.toString())

                runOnUiThread {
                    if (user != null) {
                        startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Username atau Password Anda Salah",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        btnLoginDua.setOnClickListener {
            val nama = etUserName.text.toString()
            val password = etUserPassword.text.toString()
            login.login(nama, password)
        }
    }

    override fun errorLogin() {
        Toast.makeText(this, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show()
    }

    override fun succesLogin() {
        startActivity(Intent(this@LoginActivity, MenuActivity::class.java))

    }
}