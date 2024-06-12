package com.example.agendacontatorecyclevioewfirebasebinding.viewmodel
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agendacontatorecyclevioewfirebasebinding.activity.FormularioActivity
import com.example.agendacontatorecyclevioewfirebasebinding.databinding.ListagemLayoutBinding
import com.example.agendacontatorecyclevioewfirebasebinding.model.Contato
import com.example.agendacontatorecyclevioewfirebasebinding.repository.ContatoRepository
import okhttp3.Response
import java.io.Serializable

class ContatoViewModel : ViewModel() {
    private var repositorio = ContatoRepository()
    var lista = MutableLiveData<ArrayList<Contato>>()
    var id = MutableLiveData<String?>()
    var nome = MutableLiveData<String>()
    var telefone = MutableLiveData<String>()
    var email = MutableLiveData<String>()

    init {
        lista.value = ArrayList()
        limparContato()
    }

    fun gravar(contexto : Activity) {
        repositorio.gravar(toContato() ,
            {
                contexto.runOnUiThread {
                    Toast.makeText(
                        contexto,
                        "Contato gravado com sucesso", Toast.LENGTH_LONG
                    ).show()
                    limparContato()
                }
            }, {
                contexto.runOnUiThread {
                    Toast.makeText(
                        contexto,
                        "Erro ao gravar o contato", Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    fun carregar(contexto : Activity, binding: ListagemLayoutBinding) {
        repositorio.carregar({ _: Response, listaTemp: ArrayList<Contato> ->
            contexto.runOnUiThread {
                lista.value?.clear()
                lista.value?.addAll(listaTemp)
                Log.i("AGENDA-CONTATO", "Lista no model: ${lista.value}")
                binding.rcvContatos.adapter?.notifyDataSetChanged()
            }
        }, {}
        )
    }

    fun apagarContato(contexto : Activity, contato : Contato) {
        repositorio.apagarContato(contato, {
            contexto.runOnUiThread {
                Toast.makeText(
                    contexto,
                    "Contato apagado com sucesso", Toast.LENGTH_LONG
                ).show()
            }
        }, {
            contexto.runOnUiThread {
                Toast.makeText(
                    contexto,
                    "Erro ao apagar o contato", Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    fun editarContato(contexto : Activity, contato : Contato) {
        Toast.makeText(contexto,
                "Contato selecionado para edição", Toast.LENGTH_LONG).show()
        val intent = Intent(contexto, FormularioActivity::class.java)
        intent.putExtra("CONTATO_EDITAR", contato)
        contexto.startActivity(intent)
    }

    fun extractContato(serializableExtra: Serializable?) {
        if (serializableExtra is Contato) {
            val contato : Contato = serializableExtra
            id.value = contato.id
            nome.value = contato.nome
            telefone.value = contato.telefone
            email.value = contato.email
        }
    }
    private fun limparContato() {
        id.value = null
        nome.value = ""
        telefone.value = ""
        email.value = ""
    }

    private fun toContato() : Contato {
        val c = Contato(id=id.value)
        c.nome = nome.value!!
        c.telefone = telefone.value!!
        c.email = email.value!!
        return c
    }
}