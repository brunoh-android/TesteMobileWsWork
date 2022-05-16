package br.bruno.testemobilewswork.ui.adapters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.bruno.testemobilewswork.data.api.MainRepository
import br.bruno.testemobilewswork.data.api.Carros
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val carrosList = MutableLiveData<List<Carros>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCarros() {

        val request = repository.getAllCarros()
        request.enqueue(object : Callback<List<Carros>> {
            override fun onResponse(call: Call<List<Carros>>, response: Response<List<Carros>>) {
                carrosList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Carros>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}