package com.example.testesp

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TesteActivity : AppCompatActivity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.teste_activity)

        val sp = getSharedPreferences(
            "repositorio",
            Context.MODE_PRIVATE)

        val txtTexto = findViewById<EditText>(R.id.txtTexto)
        val btnGravar = findViewById<Button>(R.id.btnGravar)
        val btnLer = findViewById<Button>(R.id.btnLer)

        btnGravar.setOnClickListener {
            // sp.edit().putString("TEXTO", txtTexto.text.toString())
            // sp.edit().commit()
            sp.edit().apply() {
                putString("TEXTO", txtTexto.text.toString())
                commit()
            }
            val toast = Toast.makeText(this,
                "Gravado com sucesso", Toast.LENGTH_LONG).show()
        }

        btnLer.setOnClickListener {
            val texto = sp.getString("TEXTO", "")
            txtTexto.setText(texto)
        }


    }



}