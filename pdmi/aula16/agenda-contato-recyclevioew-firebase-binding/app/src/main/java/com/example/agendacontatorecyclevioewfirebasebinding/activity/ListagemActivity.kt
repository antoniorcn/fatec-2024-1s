package com.example.agendacontatorecyclevioewfirebasebinding.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendacontatorecyclevioewfirebasebinding.R
import com.example.agendacontatorecyclevioewfirebasebinding.databinding.ListagemLayoutBinding
import com.example.agendacontatorecyclevioewfirebasebinding.recycle.ContatoAdapter
import com.example.agendacontatorecyclevioewfirebasebinding.viewmodel.ContatoViewModel


class ListagemActivity: AppCompatActivity() {
    private lateinit var binding : ListagemLayoutBinding
    lateinit var viewModel : ContatoViewModel
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        viewModel = ViewModelProvider(this)[ContatoViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.listagem_layout)
        binding.viewModel = viewModel
        setContentView(binding.root)
        val adapter = ContatoAdapter(this, viewModel)
        Log.i("AGENDA-CONTATO", "Adapter: $adapter")
        binding.apply {
            rcvContatos.adapter = adapter
            rcvContatos.layoutManager = LinearLayoutManager(
                this@ListagemActivity
            )
            btnFormulario.setOnClickListener {
                val intent = Intent(
                    this@ListagemActivity,
                    FormularioActivity::class.java
                )
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.carregar(this, binding)
    }
}