package br.bruno.testemobilewswork.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Comprador(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("user_id") val id: Int = 0,
    @SerializedName("nome") val nome: String,
    @SerializedName("nome_modelo") val nome_modelo: String
)

