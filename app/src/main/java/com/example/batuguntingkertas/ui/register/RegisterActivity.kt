package com.example.batuguntingkertas.ui.register

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ui.login.LoginActivity
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView

class RegisterActivity : AppCompatActivity(), RegisterNavigator {
    private lateinit var ivKembali: ImageView
    private lateinit var etUserNameRegis: EditText
    private lateinit var etUmurRegis: EditText
    private lateinit var etEmailRegis: EditText
    private lateinit var etPassRegis: EditText
    private lateinit var ivFotoProfil: ImageView
    private lateinit var btnUploadFoto: Button
    private lateinit var btnRegister: Button
    private lateinit var ivJudul: ImageView
    var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        ivKembali = findViewById(R.id.ivKembali)
        ivFotoProfil = findViewById(R.id.ivFotoProfil)
        etUserNameRegis = findViewById(R.id.etUserNameRegis)
        etUmurRegis = findViewById(R.id.etUmurRegis)
        etEmailRegis = findViewById(R.id.etEmailRegis)
        etPassRegis = findViewById(R.id.etPassRegis)
        btnUploadFoto = findViewById(R.id.btnUploadFoto)
        btnRegister = findViewById(R.id.btnRegister)
        ivJudul = findViewById(R.id.ivJudulRegis)
        val presenter = RegisterPresenter(this, this)

        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(ivJudul)

        btnRegister.setOnClickListener {
            imageUri?.path
            val nama = etUserNameRegis.text.toString()
            val umur = etUmurRegis.text.toString().toInt()
            val email = etEmailRegis.text.toString()
            val password = etPassRegis.text.toString()
            val image = imageUri?.path.toString()
            presenter.register(nama, umur, email, password, image)
        }

        btnUploadFoto.setOnClickListener {
            CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode === RESULT_OK) {
                val resultUri = result.uri
                val path = result.uri.path
                Log.d("PATH",path.toString())
                imageUri = resultUri
                ivFotoProfil.setImageURI(resultUri)
            } else if (resultCode === CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                result.error
            }
        }
    }

    override fun erroRegistrasi() {
        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
    }

    override fun succesRegistrasi() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}