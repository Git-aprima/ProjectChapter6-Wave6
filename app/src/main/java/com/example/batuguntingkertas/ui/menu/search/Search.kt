package com.example.batuguntingkertas.ui.menu.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.batuguntingkertas.R

class Search : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_search, container, false)


        //tutorhelper for search and recycleview https://github.com/stevdza-san/SearchRecyclerViewDemo/blob/master/app/src/main/java/com/example/searchrecyclerviewdemo/MainActivity.kt


        return view
    }
}
