package com.example.batuguntingkertas.ui.menu.profile.editProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.database.BigDatabase
import com.example.batuguntingkertas.data.database.UserEntity
import com.example.batuguntingkertas.ui.menu.MenuActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditProfile(private val list: List<UserEntity>, override val position: Int) : AppCompatActivity(), EditProfileNavigator {
    private lateinit var presenter: EditProfilePresenter
    private lateinit var etNama : EditText
    private lateinit var etEmail : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
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
            if(nama.isEmpty()&&email.isEmpty()){
                editGagal("Gagal disimpan")
            }else {
                presenter = EditProfilePresenter(this,this)
                presenter.editProfile(list,position)
                presenter.editSharedpref(nama)
                editBerhasil("Berhasil Disimpan")
            }
        }
        fabClose.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java))
        }
    }
    override fun editBerhasil(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }

    override fun editGagal(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }


}


