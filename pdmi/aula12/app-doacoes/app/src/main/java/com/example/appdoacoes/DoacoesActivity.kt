package com.example.appdoacoes

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException


class DoacoesActivity : Activity() {

    val nomes = arrayListOf("Joao", "Maria", "Jose")
    var clientHttp = OkHttpClient()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.doacoes_layout);
        val rcvDoacoes = findViewById<RecyclerView>(R.id.rcvDoacoes)
        rcvDoacoes.layoutManager = LinearLayoutManager(this)
        val adapter = RecycleViewAdapterDoacoes(this, nomes)
        rcvDoacoes.adapter = adapter
        val btnLer = findViewById<Button>(R.id.btnLer);
        val btnGravar = findViewById<Button>(R.id.btnGravar);

        btnLer.setOnClickListener {
            val request = Request.Builder()
                .get()
                .url("https://fatec-2024-1s-pdmi-default-rtdb.firebaseio.com/doacoes.json")
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call?, e: IOException?) {
                    Log.e("APP DOACOES", e?.message.toString())
                }
                override fun onResponse(call: Call?, response: Response?) {
                    val body = response?.body()
                    body?.charStream()?.buffered()?.lines()?.forEach {
                        Log.i("APP DOACOES", it.toString() )
                    }

                }
            }
            clientHttp.newCall( request ).enqueue( response )
        }

        btnGravar.setOnClickListener {
            val body = RequestBody.create(
                MediaType.parse("application/json"),
                """
                   { "produto": "Camisetas",
                   "estado": "usadas" }
                """.trimIndent()
            )
            val request = Request.Builder()
                .post(body)
                .url("https://fatec-2024-1s-pdmi-default-rtdb.firebaseio.com/doacoes.json")
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call?, e: IOException?) {
                    Log.e("APP DOACOES", e?.message.toString())
                }
                override fun onResponse(call: Call?, response: Response?) {
                    Log.i("APP DOACOES", "Doação cadastrada com sucesso")
                }
            }
            clientHttp.newCall(request).enqueue(response)
        }


    }

}