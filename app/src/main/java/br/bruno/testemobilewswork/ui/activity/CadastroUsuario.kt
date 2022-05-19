package br.bruno.testemobilewswork.ui.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.bruno.testemobilewswork.data.POST.JsonApi
import br.bruno.testemobilewswork.R
import br.bruno.testemobilewswork.Room.AppDatabase
import br.bruno.testemobilewswork.Room.Comprador
import br.bruno.testemobilewswork.Room.UserDao
import br.bruno.testemobilewswork.databinding.ActivityCadastroBinding
import br.bruno.testemobilewswork.ui.adapters.CadastroAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CadastroUsuario : AppCompatActivity() {


    private lateinit var binding: ActivityCadastroBinding
    private lateinit var userDao: UserDao
    private lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun sendPost() {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.wswork.com.br/cars/")
                .build()
            val jsonApi = retrofitBuilder.create(JsonApi::class.java)
            val comprador = Comprador(
                1,
                binding.edtNome.text.toString(),
                binding.carroSelecionado.text.toString()
            )
            val call = jsonApi.sendUserData(comprador)
            call.enqueue(object : Callback<Comprador> {
                override fun onResponse(call: Call<Comprador>, response: Response<Comprador>) {
                    AlertDialog.Builder(this@CadastroUsuario)
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setTitle("Message")
                        .setMessage("Escolha registrada com sucesso")
                        .setPositiveButton("ok", null)
                        .show()
                }

                override fun onFailure(call: Call<Comprador>, t: Throwable) {
                    AlertDialog.Builder(this@CadastroUsuario)
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setTitle("Alert")
                        .setMessage("Something is wrong ,\nPlease Try Again")
                        .setPositiveButton("ok", null)
                        .show()
                }
            })
        }

        this.appDatabase = AppDatabase.getInstance(this)
        this.userDao = this.appDatabase.userDao()

        val carroNome = intent.getStringExtra(CARRO_ID)
        binding.marcaModelo.text = carroNome.toString()
        binding.btnSalvar.setOnClickListener {
            val comprador = Comprador(
                nome = binding.edtNome.text.toString(),
                nome_modelo = carroNome.toString()
            )
            this.userDao.insert(comprador)
            if (binding.edtNome.text.toString().isNotEmpty()
            ) {
                AlertDialog.Builder(this)
                    .setIcon(R.mipmap.ic_launcher_round)
                    .setTitle("Message")
                    .setMessage("Escolha registrada com sucesso")
                    .setPositiveButton("ok", null)
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setIcon(R.mipmap.ic_launcher_round)
                    .setTitle("Alert")
                    .setMessage("Something is wrong ,\nPlease Try Again")
                    .setPositiveButton("ok", null)
                    .show()
            }
            sendPost()
            println(binding.btnSalvar.text)

        }

        val list = this.userDao.getAllist()
        val adapter: CadastroAdapter by lazy {
            CadastroAdapter(list)
        }
        binding.rvCadastrados.adapter = adapter

    }

    companion object {
        const val CARRO_ID = "carroId"
    }
}