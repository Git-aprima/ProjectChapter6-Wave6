package com.example.batuguntingkertas.ui.login

import android.content.Context
import com.example.batuguntingkertas.data.database.DbUser
import com.example.batuguntingkertas.data.database.UserDao
import com.example.batuguntingkertas.data.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginPresenter (context: Context, private val navigator: LoginNavigator) {
    private var userDao : UserDao? = null

    init {
        val db = DbUser.getInstance(context)
        userDao = db?.userDao()
    }

    fun login (nama : String, password : String){
        GlobalScope.launch {
            val id :UserEntity? = userDao?.getUser(nama,password)
            GlobalScope.launch (Dispatchers.Main) {
                if (id.toString()!= 0.toString()){
                    navigator.succesLogin()
                }else{
                    navigator.errorLogin()
                }
            }
        }
    }
}