package com.example.batuguntingkertas.ui.menu.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.database.DbUser
import com.example.batuguntingkertas.ui.login.LoginActivity
import com.example.batuguntingkertas.ui.menu.MenuActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Profile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEdit = view.findViewById<Button>(R.id.btnEdit)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val fabBack = view.findViewById<FloatingActionButton>(R.id.fabBack)
        val name = view.findViewById<TextView>(R.id.tvName)

        GlobalScope.launch(Dispatchers.IO) {
        val getName = activity?.let { DbUser.getInstance(it) }?.userDao()?.getValue()?.name
            name.text = getName

        }





        btnEdit.setOnClickListener {
            startActivity(Intent(activity, EditProfile::class.java))
        }

        btnLogout.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        fabBack.setOnClickListener {
            startActivity(Intent(activity, MenuActivity::class.java))
        }
    }

}