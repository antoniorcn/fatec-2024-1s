package com.example.agendacontato

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ContatoActivity() : AppCompatActivity() {
    // val lista : List<Contato> = mutableListOf()
    val lista = mutableListOf<Contato>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_activity)

        val txtNome = findViewById<EditText>(R.id.edtNome)
        val txtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val txtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val lstViewContatos = findViewById<ListView>(R.id.lstContatos)
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1)
        lstViewContatos.adapter = adapter

        btnSalvar.setOnClickListener {
            val c1 = Contato(
                txtNome.text.toString(),
                txtTelefone.text.toString(),
                txtEmail.text.toString()
                )
            lista.add(c1)
            adapter.clear()
            for( contato in lista ) {
                adapter.add(contato.toString())
            }
            Log.i("AGENDA_CONTATO", "Lista: ${lista}")
        }


    }
}