package com.example.agendacontatorecyclevioewfirebasebinding.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.agendacontatorecyclevioewfirebasebinding.R
import com.example.agendacontatorecyclevioewfirebasebinding.databinding.FormularioLayoutBinding
import com.example.agendacontatorecyclevioewfirebasebinding.model.Contato
import com.example.agendacontatorecyclevioewfirebasebinding.viewmodel.ContatoViewModel

class FormularioActivity : AppCompatActivity() {
        private lateinit var binding : FormularioLayoutBinding
        private lateinit var viewModel : ContatoViewModel

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = DataBindingUtil.setContentView(this, R.layout.formulario_layout)
        viewModel = ViewModelProvider(this)[ContatoViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewModel.extractContato(intent.getSerializableExtra("CONTATO_EDITAR"))

        binding.btnListagem.setOnClickListener {
            val intent = Intent(this, ListagemActivity::class.java)
            startActivity(intent)
        }

        binding.btnGravar.setOnClickListener {
            viewModel.gravar( this )
        }
    }
}