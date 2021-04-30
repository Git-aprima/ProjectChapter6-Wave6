package com.example.batuguntingkertas.utils

class BotRespon {

    fun responBot(msg : String): String{
        val pesan = msg.toLowerCase()

        return when {
            pesan.contains("halo") -> {
                println("halo juga").toString()
            }
            else -> "waduh gak paham"
        }
    }
}