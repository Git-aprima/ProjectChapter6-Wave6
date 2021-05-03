package com.example.batuguntingkertas.ui.menu.Friends

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.database.BigDatabase
import com.example.batuguntingkertas.data.database.FriendsEntity
import kotlinx.android.synthetic.main.activity_edit_friends.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditFriends : AppCompatActivity() {

    private var id: Int = 0
    val db = BigDatabase.getInstance(this)
    val dao = db?.friendsDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_friends)
        setUpView()
        setListener()


    }

    fun setUpView() {
        val intentType = intent.getIntExtra("intent_type", 0)
        when (intentType) {
            1 -> {

            }
            0 -> {
                btnUpdate.visibility = View.GONE
                //getFriend()
            }
        }
    }

    private fun setListener() {

        btnSave?.setOnClickListener {
            GlobalScope.launch {
                val friendName = etName.text.toString()
                val friendEmail = etEmail.text.toString()

                dao?.insertFriend(FriendsEntity(friendName, friendEmail, null))
            }
            finish()
        }

    }

//    fun getFriend() {
//        id = intent.getIntExtra("send_id", 0)
//        GlobalScope.launch {
//            val friend = dao?.getFriend(id)?.get(0)
//            etName.setText(friend?.name)
//            etEmail.setText(friend?.email)
//
//        }
//    }


}