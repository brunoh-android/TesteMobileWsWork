package br.bruno.testemobilewswork.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Comprador::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    companion object {

        private const val DATABASE_NAME: String = "CadastroUsuarios"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buidDatabase(context).also { INSTANCE = it }
            }

        private fun buidDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            ).allowMainThreadQueries().build()
    }
}