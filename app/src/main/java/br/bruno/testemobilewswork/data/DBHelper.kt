package br.bruno.testemobilewswork.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.EditText
import android.widget.Toast
import br.bruno.testemobilewswork.R

class DBHelper(context: Context): SQLiteOpenHelper(context,"CADASTRODB",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE CADASTRO(USERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT," +
                " TELEPHONE INTEGER," +
                " CARROID INTEGER," +
                " NOMEMARCA TEXT," +
                " CARROMODELO TEXT" +
                ")")

        db?.execSQL("INSERT INTO CADASTRO(NAME,TELEPHONE,CARROID,NOMEMARCA,CARROMODELO) " +
                "VALUES('bruno',3333,1,'toyota','corolla')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }




}