package com.example.batuguntingkertas.data.lokal

import android.content.Context
import com.example.batuguntingkertas.ui.menu.profile.editProfile.EditProfileActivity

class SharedPref(context: EditProfileActivity) {
    private val pref = context.getSharedPreferences("myData", Context.MODE_PRIVATE)

    private val LOGIN = "LOGIN"
    private val USERNAME = "USERNAME"
    private val PASSWORD = "PASSWORD"

    var id: Int?
        get() = pref?.getInt("ID", 0)
        set(value) {
            value?.let {
                pref?.edit()
                    ?.putInt("ID", it)
                    ?.apply()
            }
        }

    var username: String?
        get() = pref?.getString(USERNAME, "")
        set(value) {
            value.let {
                pref?.edit()
                    ?.putString(USERNAME, it)
                    ?.apply()
            }
        }

    var sandi: String?
        get() = pref?.getString(PASSWORD, "")
        set(value) {
            value.let {
                pref?.edit()
                    ?.putString(PASSWORD, it)
                    ?.apply()
            }
        }

    var isLogin: Boolean?
        get() = pref?.getBoolean(LOGIN, false)
        set(value) {
            value?.let {
                pref?.edit()
                    ?.putBoolean(LOGIN, it)
                    ?.apply()
            }
        }

}