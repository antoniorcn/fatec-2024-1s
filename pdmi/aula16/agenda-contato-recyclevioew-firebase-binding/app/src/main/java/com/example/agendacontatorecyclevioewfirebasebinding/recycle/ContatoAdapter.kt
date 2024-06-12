package com.example.agendacontatorecyclevioewfirebasebinding.recycle

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendacontatorecyclevioewfirebasebinding.R
import com.example.agendacontatorecyclevioewfirebasebinding.model.Contato
import com.example.agendacontatorecyclevioewfirebasebinding.repository.ContatoRepository
import com.example.agendacontatorecyclevioewfirebasebinding.viewmodel.ContatoViewModel

class ContatoAdapter(private val contexto : Activity, private val viewModel : ContatoViewModel) :
    RecyclerView.Adapter<ContatoViewHolder>() {
    private var inflater: LayoutInflater = LayoutInflater.from(contexto)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = inflater.inflate(
            R.layout.contato_row_layout,
            parent, false)
        return ContatoViewHolder( view )
    }
    override fun getItemCount(): Int {
        return viewModel.lista.value!!.size
    }
    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = viewModel.lista.value!![position]
        holder.txtNome.text = contato.nome
        holder.txtTelefone.text = contato.telefone
        holder.txtEmail.text = contato.email
        holder.btnRowApagar.setOnClickListener {
            Log.i("AGENDA-CONTATO",
                "Contato selecionado para apagar: $contato")
            viewModel.apagarContato(contexto, contato)
        }
        holder.btnRowEditar.setOnClickListener {
            Log.i("AGENDA-CONTATO",
                "Contato selecionado para editar: $contato")
            viewModel.editarContato(contexto, contato)
        }
    }
}