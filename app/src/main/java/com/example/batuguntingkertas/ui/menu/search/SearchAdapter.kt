package com.example.batuguntingkertas.ui.menu.search

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.batuguntingkertas.R
import kotlin.coroutines.coroutineContext

class SearchAdapter(val listSearch :ArrayList<SearchData>):
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSearch.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvNamaMember).text = listSearch[position].nama
        holder.itemView.findViewById<TextView>(R.id.tvEmailMember).text = listSearch[position].email
    }
}