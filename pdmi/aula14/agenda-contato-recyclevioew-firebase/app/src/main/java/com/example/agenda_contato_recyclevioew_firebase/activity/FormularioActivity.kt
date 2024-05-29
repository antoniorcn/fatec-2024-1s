package com.example.agenda_contato_recyclevioew_firebase.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda_contato_recyclevioew_firebase.R
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException

class FormularioActivity : AppCompatActivity() {

    var clientHttp = OkHttpClient()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.formulario_layout)

        val btnGravar = findViewById<Button>(R.id.btnGravar)
        btnGravar.setOnClickListener {
            val txtNome = findViewById<EditText>(R.id.txtNome)
            val txtTelefone = findViewById<EditText>(R.id.txtTelefone)
            val txtEmail = findViewById<EditText>(R.id.txtEmail)

            val body = RequestBody.create(
                MediaType.parse("application/json"),
                """
                    {
                        "nome": "${txtNome.text}",
                        "telefone": "${txtTelefone.text}",
                        "email": "${txtEmail.text}"
                    }
                """.trimIndent()
            )

            val request = Request.Builder()
                .post(body)
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
}