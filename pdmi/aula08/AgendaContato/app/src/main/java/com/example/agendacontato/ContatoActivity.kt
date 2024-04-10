package com.example.agendacontato

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ContatoActivity() : AppCompatActivity() {
    // val lista : List<Contato> = mutableListOf()
    val lista = mutableListOf<Contato>()
    val gson = Gson()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_activity)

        val sp = getSharedPreferences("agenda.contato", Context.MODE_PRIVATE)

        val listaString = sp.getString("LISTA", "[]")
        val arrayContatoType = object : TypeToken<MutableList<Contato>>() {}.type
        lista.clear()
        lista.addAll(gson.fromJson(listaString, arrayContatoType))

        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1)
        val lstViewContatos = findViewById<ListView>(R.id.lstContatos)
        lstViewContatos.adapter = adapter


        adapter.clear()
        for( contato in lista ) {
            adapter.add(contato.toString())
        }

        val txtNome = findViewById<EditText>(R.id.edtNome)
        val txtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val txtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            val c1 = Contato(
                txtNome.text.toString(),
                txtTelefone.text.toString(),
                txtEmail.text.toString()
                )
            lista.add(c1)

            var listaString = gson.toJson(lista)
            Log.i("AGENDA CONTATO", listaString)

            sp.edit().apply {
                putString("LISTA", listaString)
                commit()
            }

            adapter.clear()
            for( contato in lista ) {
                adapter.add(contato.toString())
            }
            Log.i("AGENDA_CONTATO", "Lista: ${lista}")
        }


    }
}