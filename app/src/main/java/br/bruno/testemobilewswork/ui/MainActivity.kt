package br.bruno.testemobilewswork.ui

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.bruno.mvvm.adapters.MainAdapter
import br.bruno.testemobilewswork.R
import br.bruno.testemobilewswork.data.Carros
import br.bruno.testemobilewswork.data.DBHelper
import br.bruno.testemobilewswork.data.MainRepository
import br.bruno.testemobilewswork.data.RetrofitService
import br.bruno.testemobilewswork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()

    lateinit var carros: Carros

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

    fun getCadastro() {

        var helper = DBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM CADASTRO", null)
        if (rs.moveToNext())
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()

        val cv = ContentValues()
        val dialogNome =findViewById<EditText>(R.id.dialog_nome)

        cv.put("NAME", dialogNome.text.toString())
        cv.put("TELEPHONE", findViewById<EditText>(R.id.dialog_telefone).toString().toInt())
        cv.put("CARROID", carros.id.toString().toInt())
        cv.put("NOMEMARCA", carros.marca_nome)
        cv.put("CARROMODELO", carros.nome_modelo)

        dialogNome.setText("")

        db.insert("CADASTRO", null, cv)
    }
}



