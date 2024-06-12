package com.example.agendacontatorecyclevioewfirebasebinding.model

import java.io.Serializable

data class Contato (
    var id : String? = null,
    var nome : String = "",
    var telefone : String = "",
    var email : String = ""
    ) : Serializable {
    override fun toString() : String {
        return this.nome + "-" + this.telefone
    }
}
