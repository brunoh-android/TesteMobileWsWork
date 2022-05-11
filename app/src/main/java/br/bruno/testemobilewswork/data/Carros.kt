package br.bruno.testemobilewswork.data

data class Carros(
    val id: Int,
    val marca_id: Int,
    val marca_nome: String,
    val nome_modelo: String,
    val ano: Int,
    val combustivel: String,
    val num_portas: Int,
    val valor_fipe: String,
    val cor: String,
    val timestamp_cadastro: Int


)