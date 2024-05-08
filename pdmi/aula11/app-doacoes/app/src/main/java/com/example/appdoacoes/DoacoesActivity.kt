package com.example.appdoacoes

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DoacoesActivity : Activity() {

    val nomes = arrayListOf("Joao", "Maria", "Jose")

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.doacoes_layout);

        val rcvDoacoes = findViewById<RecyclerView>(R.id.rcvDoacoes)
        rcvDoacoes.layoutManager = LinearLayoutManager(this)
        val adapter = RecycleViewAdapterDoacoes(this, nomes)
        rcvDoacoes.adapter = adapter

    }

}