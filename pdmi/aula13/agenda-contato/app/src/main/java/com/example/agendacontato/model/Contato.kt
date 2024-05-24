package com.example.agendacontato.model

data class Contato (
    var nome : String = "",
    var telefone : String = "",
    var email : String = ""
    ) {
    override fun toString() : String {
        return this.nome + "-" + this.telefone
    }
}
