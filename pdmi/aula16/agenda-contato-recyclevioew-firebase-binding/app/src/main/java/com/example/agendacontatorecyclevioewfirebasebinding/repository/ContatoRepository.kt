package com.example.agendacontatorecyclevioewfirebasebinding.repository

import android.util.Log
import com.example.agendacontatorecyclevioewfirebasebinding.model.Contato
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException

class ContatoRepository {
    private val clientHttp = OkHttpClient()
    private val gson = Gson()

    fun gravar(contato : Contato,
               onSuccess : (Response) -> Unit,
               onFail : (IOException) -> Unit,) {
        Log.i("AGENDA-CONTATO", "Gravar acionado")
        val jsonBody = """
                    {
                        "nome": "${contato.nome}",
                        "telefone": "${contato.telefone}",
                        "email": "${contato.email}"
                    }
                """.trimIndent()
        val body = RequestBody.create(
            MediaType.parse("application/json"),
            jsonBody
        )
        Log.i("AGENDA-CONTATO", "Body criado: $jsonBody")
        val requestBuilder = Request.Builder()
        if (contato.id == null)
            requestBuilder.post(body)
                .url("https://fatec-2024-1s-pdmi-default-rtdb.firebaseio.com/agenda.json")
        else
            requestBuilder.put(body)
                .url("https://fatec-2024-1s-pdmi-default-rtdb.firebaseio.com/agenda/${contato.id}.json")
        val request = requestBuilder.build()
        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA-CONTATO", e.message.toString())
                onFail(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val localBody = response?.body()
                Log.i("AGENDA-CONTATO", localBody!!.string())
                onSuccess(response)
            }
        }
        clientHttp.newCall(request).enqueue(response)
    }

    fun carregar(onSuccess: (Response, ArrayList<Contato>) -> Unit, onFail: (IOException) -> Unit) {
        val request = Request.Builder()
            .get()
            .url("https://fatec-2024-1s-pdmi-default-rtdb.firebaseio.com/agenda.json")
            .build()
        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA-CONTATO", e.message.toString())
                onFail(e)
            }
            override fun onResponse(call: Call, response: Response) {
                Log.i("AGENDA-CONTATO", "Dados recebidos convertendo")
                val body = response.body()
                val bodyJson = body?.string()
                if (bodyJson != null && bodyJson != "null") {
                    Log.i("AGENDA-CONTATO", "BodyJSON recebido: '$bodyJson'")
                    val type = object : TypeToken<HashMap<String?, Contato?>?>() {}.type
                    val myMap: HashMap<String, Contato> = gson.fromJson(bodyJson, type)
                    val listaTemp = ArrayList<Contato>()
                    myMap.keys.forEach {
                        val contato = myMap[it]
                        if (contato != null) {
                            contato.id = it
                            Log.i("AGENDA-CONTATO", "Contato: $contato")
                            listaTemp.add(contato)
                        }
                    }
                    onSuccess(response, listaTemp)
                }
            }
        }
        clientHttp.newCall(request).enqueue(response)
    }

    fun apagarContato(contato : Contato,
                      onSuccess : (Response) -> Unit,
                      onFail : (IOException) -> Unit,
                      ) {
        val request = Request.Builder()
            .delete()
            .url("https://fatec-2024-1s-pdmi-default-rtdb.firebaseio.com/agenda/${contato.id}.json")
            .build()
        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA-CONTATO", e.message.toString())
                onFail(e)
            }
            override fun onResponse(call: Call, response: Response) {
                Log.e("AGENDA-CONTATO", "Contato apagado com sucesso")
                onSuccess(response)
            }
        }
        clientHttp.newCall(request).enqueue(response)
    }
}