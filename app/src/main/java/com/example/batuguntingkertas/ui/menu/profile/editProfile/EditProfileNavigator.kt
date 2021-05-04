package com.example.batuguntingkertas.ui.menu.profile.editProfile

interface EditProfileNavigator {
    abstract val position: Int

    fun editBerhasil(msg : String)
    fun editGagal(msg : String)
}