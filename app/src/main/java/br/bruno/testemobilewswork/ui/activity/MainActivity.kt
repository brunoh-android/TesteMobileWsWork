package br.bruno.testemobilewswork.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.bruno.testemobilewswork.ui.adapters.MainAdapter
import br.bruno.testemobilewswork.R
import br.bruno.testemobilewswork.data.api.MainRepository
import br.bruno.testemobilewswork.data.api.RetrofitService
import br.bruno.testemobilewswork.databinding.ActivityMainBinding
import br.bruno.testemobilewswork.ui.adapters.MainViewModel
import br.bruno.testemobilewswork.ui.adapters.MainViewModelFactory

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recyclerview.adapter = adapter

    }

    override fun onStart() {
        super.onStart()

        viewModel.carrosList.observe(this, Observer { carros ->
            adapter.setCarrosList(carros)
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllCarros()
    }
}



