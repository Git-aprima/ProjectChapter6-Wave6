package com.example.batuguntingkertas.ui.menu.profile.editProfile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.database.UserEntity
import com.example.batuguntingkertas.ui.menu.MenuActivity

class EditProfileActivity(private val list: List<UserEntity>, override val position: Int) :
    AppCompatActivity(), EditProfileNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var presenter: EditProfilePresenter
        lateinit var etNama: EditText
        lateinit var etEmail: EditText

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        etNama = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val fabClose = findViewById<Button>(R.id.fabClose)
        val nama = list[position].name
        val email = list[position].email
        etNama.setText(nama)
        etEmail.setText(email)
        btnSave.setOnClickListener {
            if (nama.isEmpty() && email.isEmpty()) {
                editGagal("Gagal disimpan")
            } else {
                presenter = EditProfilePresenter(this, this)
                presenter.editProfile(list, position)
                presenter.editSharedpref(nama)
                editBerhasil("Berhasil Disimpan")
            }
        }
        fabClose.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    override fun editBerhasil(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }

    override fun editGagal(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }
}