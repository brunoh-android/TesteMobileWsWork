package br.bruno.testemobilewswork.data.api

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllCarros() = retrofitService.getallCarros()


}