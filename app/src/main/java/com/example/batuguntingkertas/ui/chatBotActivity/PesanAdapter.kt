package com.example.batuguntingkertas.ui.chatBotActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.utils.KonteksPesan.ID_KIRIM
import com.example.batuguntingkertas.utils.KonteksPesan.ID_TERIMA

class PesanAdapter : RecyclerView.Adapter<PesanAdapter.PesanViewHolder>() {

    var listPesan = mutableListOf<Pesan>()

    inner class PesanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                listPesan.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesanViewHolder {
        return PesanViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pesan_item,parent,false))
    }

    override fun onBindViewHolder(holder: PesanViewHolder, position: Int) {
        val posisiPesan = listPesan[position]

        when(posisiPesan.id){
            ID_KIRIM -> {
                holder.itemView.findViewById<TextView>(R.id.tvPesanUser).apply {
                    text = posisiPesan.pesan
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tvPesanBot).visibility = View.GONE
            }
            ID_TERIMA -> {
                holder.itemView.findViewById<TextView>(R.id.tvPesanBot).apply {
                    text = posisiPesan.pesan
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tvPesanUser).visibility = View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
        return listPesan.size
    }

    fun pesanMasuk(pesan: Pesan){
        this.listPesan.add(pesan)
        notifyItemInserted(listPesan.size)
    }

}