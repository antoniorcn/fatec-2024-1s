package com.example.agendacontatorecyclevioewfirebasebinding.activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.agendacontatorecyclevioewfirebasebinding.databinding.TesteDataLayoutBinding
import com.example.agendacontatorecyclevioewfirebasebinding.viewmodel.ContadorViewModel
class TesteContadorActivity : AppCompatActivity() {
    private lateinit var binding : TesteDataLayoutBinding
    private lateinit var viewModel : ContadorViewModel
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ContadorViewModel::class.java]
        binding = TesteDataLayoutBinding.inflate(layoutInflater)
        binding.contador = viewModel.contador.value
        binding.btnIncrementar.setOnClickListener {
            viewModel.incrementar()
            binding.contador = viewModel.contador.value
        }
        setContentView(binding.root)
    }
}