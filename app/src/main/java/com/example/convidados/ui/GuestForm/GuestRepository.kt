package com.example.convidados.ui.GuestForm

import android.content.ContentValues
import android.content.Context
import android.content.LocusId
import com.example.convidados.Constants.DataBaseConstants
import java.lang.Exception

class GuestRepository private constructor(context: Context) {

    private val guestDataBase = GuestDataBase(context)


    //Singleton
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!Companion::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun insert(guest: GuestModel): Boolean {
        val TABLENAME = DataBaseConstants.GUEST.TABLE_NAME
        val ID = DataBaseConstants.GUEST.COLUMNS.ID
        val NAME = DataBaseConstants.GUEST.COLUMNS.NAME
        val PRESENCE = DataBaseConstants.GUEST.COLUMNS.PRESENCE

        return try {
            val db = guestDataBase.writableDatabase

            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()
            values.put(NAME, guest.name)
            values.put(PRESENCE, presence)

            db.insert(TABLENAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(guest: GuestModel): Boolean {

        return try {
            val db = guestDataBase.writableDatabase

            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

            val selection = " ${DataBaseConstants.GUEST.COLUMNS.ID} = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, selection, args)

            true

        } catch (e: Exception) {

            false

        }

    }

    fun delete(id: Int): Boolean {

        return try {
            val db = guestDataBase.writableDatabase

            val selection = " ${DataBaseConstants.GUEST.COLUMNS.ID} = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)

            true

        } catch (e: Exception) {

            false

        }

    }

    fun getAll(): List<GuestModel> {

        val TABLENAME = DataBaseConstants.GUEST.TABLE_NAME
        val ID = DataBaseConstants.GUEST.COLUMNS.ID
        val NAME = DataBaseConstants.GUEST.COLUMNS.NAME
        val PRESENCE = DataBaseConstants.GUEST.COLUMNS.PRESENCE

        val list = mutableListOf<GuestModel>()

        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                ID,
                NAME,
                PRESENCE
            )

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(ID))
                    val name = cursor.getString(cursor.getColumnIndex(NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(PRESENCE))

                    val guest = GuestModel(id, name, presence == 1)

                    list.add(guest)
                }
            }
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }

    fun getPresent(): List<GuestModel> {

        val TABLENAME = DataBaseConstants.GUEST.TABLE_NAME
        val ID = DataBaseConstants.GUEST.COLUMNS.ID
        val NAME = DataBaseConstants.GUEST.COLUMNS.NAME
        val PRESENCE = DataBaseConstants.GUEST.COLUMNS.PRESENCE

        val list = mutableListOf<GuestModel>()

        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                ID,
                NAME,
                PRESENCE
            )

            val selection = " ${DataBaseConstants.GUEST.COLUMNS.ID} = ?"
            val args = arrayOf("1")

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection,
                selection,
                args,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(ID))
                    val name = cursor.getString(cursor.getColumnIndex(NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(PRESENCE))

                    val guest = GuestModel(id, name, presence == 1)

                    list.add(guest)
                }
            }
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }

    fun getAbsent(): List<GuestModel> {

        val TABLENAME = DataBaseConstants.GUEST.TABLE_NAME
        val ID = DataBaseConstants.GUEST.COLUMNS.ID
        val NAME = DataBaseConstants.GUEST.COLUMNS.NAME
        val PRESENCE = DataBaseConstants.GUEST.COLUMNS.PRESENCE

        val list = mutableListOf<GuestModel>()

        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                ID,
                NAME,
                PRESENCE
            )

            val selection = " ${DataBaseConstants.GUEST.COLUMNS.ID} = ?"
            val args = arrayOf("0")

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection,
                selection,
                args,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(ID))
                    val name = cursor.getString(cursor.getColumnIndex(NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(PRESENCE))

                    val guest = GuestModel(id, name, presence == 1)

                    list.add(guest)
                }
            }
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }


}