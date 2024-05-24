package com.example.agendacontato.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendacontato.R
import com.example.agendacontato.model.Contato
import java.util.zip.Inflater

class ContatoAdapter(val contexto : Context, val lista : ArrayList<Contato>) :
    RecyclerView.Adapter<ContatoViewHolder>() {

    var inflater: LayoutInflater = LayoutInflater.from(contexto)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = inflater.inflate(R.layout.contato_row_layout,
            parent, false)
        return ContatoViewHolder( view )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = lista[position]
        holder.txtNome.text = contato.nome
        holder.txtTelefone.text = contato.telefone
        holder.txtEmail.text = contato.email
    }
}