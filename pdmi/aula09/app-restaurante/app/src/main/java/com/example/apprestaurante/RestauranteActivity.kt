package com.example.apprestaurante

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.gson.Gson

class RestauranteActivity : Activity() {

    val restaurantes = ArrayList<Restaurante>()
    val gson = Gson()

    override fun onCreate( bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.restaurante_layout)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtDescricao = findViewById<EditText>(R.id.edtDescricao)
        val edtEndereco = findViewById<EditText>(R.id.edtEndereco)
        val edtLatitude = findViewById<EditText>(R.id.edtLatitude)
        val edtLongitude = findViewById<EditText>(R.id.edtLongitude)
        val edtTipo = findViewById<EditText>(R.id.edtTipo)
        val lstView = findViewById<ListView>(R.id.lstRestaurantes)

        val itemsAdapter = ArrayAdapter<Restaurante>(this,
            android.R.layout.simple_list_item_1, restaurantes);

        lstView.adapter = itemsAdapter

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnVerLista = findViewById<Button>(R.id.btnVerLista)

        btnSalvar.setOnClickListener {
            val r = Restaurante(0,
                edtNome.text.toString(),
                edtEndereco.text.toString(),
                edtLatitude.text.toString().toDouble(),
                edtLongitude.text.toString().toDouble(),
                edtTipo.text.toString(),
                0,
                edtDescricao.text.toString()
            )
            restaurantes.add( r )
            salvarPrefs()
        }

        btnVerLista.setOnClickListener {
            carregarPrefs()
            itemsAdapter.clear()
            itemsAdapter.addAll(restaurantes)
        }





    }

    fun salvarPrefs() {
        val strRestaurantes = gson.toJson(restaurantes)
        Log.i("RESTAURANTES", strRestaurantes)
        val sp = this.getSharedPreferences("RESTAURANTES", MODE_PRIVATE)
//        val edit = sp.edit()
//        edit.putString("LISTA_RESTAURANTES", strRestaurantes)
//        edit.commit()
        sp.edit().apply {
            putString("LISTA_RESTAURANTES", strRestaurantes)
            commit()
        }
    }

    fun carregarPrefs() {
        val sp = this.getSharedPreferences("RESTAURANTES", MODE_PRIVATE)
        val strRestaurantes = sp.getString("LISTA_RESTAURANTES", "[]")
        val lista = gson.fromJson(strRestaurantes, ArrayList<Restaurante>()::class.java)

        restaurantes.clear()
        restaurantes.addAll( lista )

    }

}