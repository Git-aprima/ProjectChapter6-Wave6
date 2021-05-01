package com.example.batuguntingkertas.utils

import com.example.batuguntingkertas.utils.KonteksPesan.OPEN_SEARCH
import com.example.batuguntingkertas.utils.KonteksPesan.OPEN_TUTORIAL

object BotRespon {

    fun respon(pesanRespon: String): String {
        val pesan = pesanRespon.toLowerCase()

        return when {
            pesan.contains("halo") -> " halo juga"
            pesan.contains("cari") -> {
                OPEN_SEARCH
            }
            pesan.contains("tutorial") -> {
                OPEN_TUTORIAL
            }
            else -> "waduh, maaf gak mudeng"
        }
    }
}