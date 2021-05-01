package com.example.batuguntingkertas.ui.register

import android.content.Context
import com.example.batuguntingkertas.database.DbUser
import com.example.batuguntingkertas.database.UserDao
import com.example.batuguntingkertas.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterPresenter(context: Context, private val navigator: RegisterNavigator){
    private var userDao: UserDao? = null

    init {
        val db = DbUser.getInstance(context)
        userDao = db?.userDao()
    }

    fun register(username : String, email : String, password : String, name: String, image : String) {
        val user = UserEntity(username, email, password, name, image )
        GlobalScope.launch {
            val id = userDao?.insertUser(user)
            GlobalScope.launch(Dispatchers.Main) {
                if (user.username.isNotEmpty() && user.email.isNotEmpty() && user.name.isNotEmpty() && user.password.isNotEmpty()) {
                    navigator.succesRegistrasi()
                } else {
                    navigator.erroRegistrasi()
                }
            }
        }
    }
}