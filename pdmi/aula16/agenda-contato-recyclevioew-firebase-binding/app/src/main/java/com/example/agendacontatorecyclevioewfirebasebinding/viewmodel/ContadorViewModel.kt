package com.example.agendacontatorecyclevioewfirebasebinding.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class ContadorViewModel : ViewModel() {
    private var _contador = MutableLiveData<Int>()
    val contador : LiveData<Int> = _contador
    init {
        _contador.value = 0
    }
    fun setContador(value : Int) {
        _contador.value = value
    }
    fun incrementar() {
        _contador.value = _contador.value!!.plus(1)
    }
}