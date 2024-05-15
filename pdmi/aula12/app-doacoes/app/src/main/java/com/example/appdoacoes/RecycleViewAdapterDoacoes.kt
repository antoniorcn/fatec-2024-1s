package com.example.appdoacoes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
class RecycleViewAdapterDoacoes(context : Context, list : List<String>) :
    RecyclerView.Adapter<DoacoesViewHolder>() {
        var lista : List<String>
        var inflater : LayoutInflater
    init {
        lista = list
        inflater = LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int) : DoacoesViewHolder {
        val view = inflater.inflate(R.layout.doacoes_row_layout,
            parent, false)
        return DoacoesViewHolder(view)
    }
    override fun onBindViewHolder(holder: DoacoesViewHolder, position: Int) {
        val texto = lista[position]
        holder.txtNome.text = texto
    }
    override fun getItemCount(): Int {
        return lista.size
    }
}