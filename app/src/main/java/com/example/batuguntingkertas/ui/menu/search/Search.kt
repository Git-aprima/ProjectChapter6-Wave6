package com.example.batuguntingkertas.ui.menu.search

import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.database.DbUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Search : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_search, container, false)
        val listSearch = mutableListOf<SearchData>()
        val adapter = SearchAdapter(listSearch as ArrayList<SearchData>)
        val rvListTeman = view.findViewById<RecyclerView>(R.id.rvListTeman)
        rvListTeman.adapter = adapter
        rvListTeman.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        return view
    }

}
