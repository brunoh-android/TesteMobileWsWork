package br.bruno.testemobilewswork.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.bruno.testemobilewswork.data.MainRepository

class MainViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalAccessException("ViewModel Not Found")
        }
    }

}