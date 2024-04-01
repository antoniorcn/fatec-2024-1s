package com.example.conversormoedas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConversorActivity : AppCompatActivity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.conversor_activity)

        val edtMoeda = findViewById<EditText>(R.id.edtMoeda)
        val edtCambio = findViewById<EditText>(R.id.edtCambio)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val moeda = edtMoeda.text.toString().toFloat()
            val cambio = edtCambio.text.toString().toFloat()
            val resultado = moeda * cambio
            txtResultado.text = "Resultado em US$: $resultado"
        }
    }
}