package br.bruno.testemobilewswork.data.POST

import br.bruno.testemobilewswork.Room.Comprador
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JsonApi {
    @POST("leads")
    fun sendUserData(
        @Body comprador: Comprador
    ):Call<Comprador>
}