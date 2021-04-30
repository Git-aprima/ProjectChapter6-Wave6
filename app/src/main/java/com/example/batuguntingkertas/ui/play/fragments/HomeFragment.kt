package com.example.batuguntingkertas.ui.play.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R


class HomeFragment : Fragment() {
    private lateinit var icon:ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Permission Gilde
        icon = view.findViewById(R.id.icon)
        Glide.with(this)
            .load("https://i.ibb.co/HC5ZPgD/splash-screen%201.png")
            .into(icon)

    }

}