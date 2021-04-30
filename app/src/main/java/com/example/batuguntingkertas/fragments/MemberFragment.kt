package com.example.batuguntingkertas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R

class MemberFragment : Fragment() {
    private lateinit var icWellcome: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Permission Gilde
        icWellcome = view.findViewById(R.id.icWelcome)
        Glide.with(this)
            .load("https://www.freepnglogos.com/uploads/welcome-png/wonderful-welcome-images-18.png")
            .into(icWellcome)

    }


}