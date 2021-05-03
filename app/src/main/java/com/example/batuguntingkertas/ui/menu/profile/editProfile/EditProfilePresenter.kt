package com.example.batuguntingkertas.ui.menu.profile.editProfile

import android.content.Context
import android.content.SharedPreferences
import com.example.batuguntingkertas.data.database.BigDatabase
import com.example.batuguntingkertas.data.database.UserDao
import com.example.batuguntingkertas.data.database.UserEntity
import com.example.batuguntingkertas.data.lokal.SharedPref
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditProfilePresenter(context: Context, private val edit: EditProfileNavigator) {

    private var userDao: UserDao? = null
    val pref = SharedPref(context as EditProfile)

    init {
        val userDb = BigDatabase.getInstance(context)
        userDao = userDb?.userDao()
    }

    fun editProfile(list: List<UserEntity>, position: Int) {
        GlobalScope.launch {
            val ganti = userDao?.updateUser(list[position])
            GlobalScope.launch(Dispatchers.Main) {
                if (ganti != 0) {
                    edit.editBerhasil("Edit profile berhasil")
                } else {
                    edit.editGagal("Edit profile gagal")
                }
            }
        }
    }
    fun editSharedpref(username : String){
        pref.username = username
    }

}



