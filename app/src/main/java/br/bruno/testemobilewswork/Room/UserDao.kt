package br.bruno.testemobilewswork.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(comprador: Comprador)

    @Query("SELECT * FROM Comprador")
    fun getAllist(): List<Comprador>
}