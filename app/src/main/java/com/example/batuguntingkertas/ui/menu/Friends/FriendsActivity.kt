package com.example.batuguntingkertas.ui.menu.Friends

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.data.database.BigDatabase
import com.example.batuguntingkertas.data.database.FriendsEntity
import kotlinx.android.synthetic.main.activity_friends.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FriendsActivity : AppCompatActivity() {

    val db = BigDatabase.getInstance(this)
    val dao = db?.friendsDao()
    lateinit var friendAdapter: FriendsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
        setListener()
        setRecycler()
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            val friends = dao?.getAllFriends()
            GlobalScope.launch(Dispatchers.Main){
                friends?.let { friendAdapter.setData(it) }
            }
        }
    }

    fun setListener() {
        val btnTambahTeman = findViewById<Button>(R.id.btnTambahTeman)
        btnTambahTeman?.setOnClickListener {
           intentEdit(0, 0)

        }
    }

    fun intentEdit(id: Int, intentType: Int){
        startActivity(
            Intent(applicationContext, EditFriends::class.java)
                .putExtra("send_id", id)
                .putExtra("intent_type", intentType)
        )
    }

    fun setRecycler() {
        friendAdapter = FriendsAdapter(mutableListOf(), object : FriendsAdapter.OnListener{
            override fun onClick(friends: FriendsEntity) {
                friends.idFriend?.let { intentEdit(it, 0) }
            }
        })

        rvListFriends.apply {
            layoutManager = LinearLayoutManager(this@FriendsActivity)
            adapter = friendAdapter
        }
    }
}