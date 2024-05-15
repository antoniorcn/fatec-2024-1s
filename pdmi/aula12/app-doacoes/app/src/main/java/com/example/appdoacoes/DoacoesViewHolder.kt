package com.example.appdoacoes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoacoesViewHolder(view :View) : RecyclerView.ViewHolder(view) {

    var txtNome : TextView
    var txtEstado : TextView

    init {
        txtNome = view.findViewById(R.id.txtNome)
        txtEstado = view.findViewById(R.id.txtEstado)
    }

}