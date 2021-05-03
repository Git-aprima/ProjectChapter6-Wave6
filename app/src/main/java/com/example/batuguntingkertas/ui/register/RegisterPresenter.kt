package com.example.batuguntingkertas.ui.register

import android.content.Context
import com.example.batuguntingkertas.data.database.BigDatabase
import com.example.batuguntingkertas.data.database.UserDao
import com.example.batuguntingkertas.data.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterPresenter(context: Context, private val navigator: RegisterNavigator){
    private var userDao: UserDao? = null

    init {
        val db = BigDatabase.getInstance(context)
        userDao = db?.userDao()
    }

    fun register(username : String, email : String, password : String, name: String, image : String) {
        val user = UserEntity(username, email, password, name, image,0)
        GlobalScope.launch {
            val id = userDao?.insertUser(user)
            GlobalScope.launch(Dispatchers.Main) {
                if (user.username.isNotEmpty() && user.email.isNotEmpty() && user.name.isNotEmpty() && user.password.isNotEmpty()) {
                    navigator.succesRegistrasi()
                } else {
                    navigator.errorRegistrasi()
                }
            }
        }
    }
}