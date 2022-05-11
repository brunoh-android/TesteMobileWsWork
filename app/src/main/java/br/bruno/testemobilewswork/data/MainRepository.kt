package br.bruno.testemobilewswork.data

import br.bruno.testemobilewswork.data.RetrofitService
import br.bruno.testemobilewswork.ui.MainActivity

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllCarros() = retrofitService.getallCarros()


}