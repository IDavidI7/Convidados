package com.example.convidados.ui.GuestForm

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.convidados.Constants.DataBaseConstants

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "guestdb"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        //Criação do banco

        val TABLENAME = DataBaseConstants.GUEST.TABLE_NAME
        val ID = DataBaseConstants.GUEST.COLUMNS.ID
        val NAME = DataBaseConstants.GUEST.COLUMNS.NAME
        val PRESENCE = DataBaseConstants.GUEST.COLUMNS.PRESENCE

        db.execSQL("create table $TABLENAME ($ID integer primary key autoincrement, $NAME text, $PRESENCE integer);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}