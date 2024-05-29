package com.example.agenda_contato_recyclevioew_firebase.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda_contato_recyclevioew_firebase.R
import com.example.agenda_contato_recyclevioew_firebase.model.Contato
import com.example.agenda_contato_recyclevioew_firebase.recycle.ContatoAdapter
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ListagemActivity: AppCompatActivity() {
    val lista = ArrayList<Contato>()
    var clientHttp = OkHttpClient()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.listagem_layout)

        lista.add(Contato("Joao Silva", "(11) 1111-1111", "joao@teste.com"))
        lista.add(Contato("Maria Silva", "(11) 2222-2222", "maria@teste.com"))

        val rcvContatos = findViewById<RecyclerView>(R.id.rcvContatos)
        val adapter = ContatoAdapter(this, lista)
        rcvContatos.adapter = adapter
        rcvContatos.layoutManager = LinearLayoutManager(this)

        val btnFormulario = findViewById<Button>(R.id.btnFormulario)
        btnFormulario.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val request = Request.Builder()
            .get()
            .url("https://fatec-2024-1s-pdmi-default-rtdb.firebaseio.com/agenda.json")
            .build()
        val response = object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                Log.e("AGENDA-CONTATO", e?.message.toString())
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()
                body?.charStream()?.buffered()?.lines()?.forEach {
                    Log.i("AGENDA-CONTATO", it.toString())
                }

            }
        }
        clientHttp.newCall(request).enqueue(response)
    }
}