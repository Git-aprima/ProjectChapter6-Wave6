package com.example.batuguntingkertas.ui.register

import android.content.Context
import com.example.batuguntingkertas.data.database.DbUser
import com.example.batuguntingkertas.data.database.UserDao
import com.example.batuguntingkertas.data.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterPresenter(context: Context, private val navigator: RegisterNavigator){
    private var userDao: UserDao? = null

    init {
        val db = DbUser.getInstance(context)
        userDao = db?.userDao()
    }

    fun register(nama : String, umur : Int, email : String, password : String, image : String) {
        val user = UserEntity(nama, umur, email, password, image)
        GlobalScope.launch {
            val id = userDao?.insertUser(user)?:0
            GlobalScope.launch(Dispatchers.Main) {
                if (id >= (1).toLong()) {
                    navigator.succesRegistrasi()
                } else {
                    navigator.erroRegistrasi()
                }
            }
        }
    }
}