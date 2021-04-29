package com.example.batuguntingkertas.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.database.DbUser
import com.example.batuguntingkertas.ui.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), LoginNavigator {

    private lateinit var etUserName : EditText
    private lateinit var etUserPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnLoginDua : Button
    private lateinit var tvBuatAkun : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUserName = findViewById(R.id.etUsername)
        etUserPassword = findViewById(R.id.etUserPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLoginDua = findViewById(R.id.btnLoginDua)
        tvBuatAkun = findViewById(R.id.tvBuatAkun)
        val login = LoginPresenter (this,this)

        //Tanpa Pattern MVP dulu
        val mDb = DbUser.getInstance(this)

        btnLogin.setOnClickListener{
            GlobalScope.launch {
                val user = mDb?.userDao()?.getUser(etUserName.text.toString(),etUserPassword.text.toString())

                runOnUiThread {
                    if (user!= null){
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    } else {
                        Toast.makeText(this@LoginActivity, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        btnLoginDua.setOnClickListener {
            val nama = etUserName.text.toString()
            val password = etUserPassword.text.toString()
            login.login(nama,password)
        }
    }

    override fun errorLogin() {
        Toast.makeText(this, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show()
    }

    override fun succesLogin() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

    }
}