
package com.tuempresa.camisetas.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "carrito.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE carrito(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT," +
                    "precio TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldV: Int, newV: Int) {
        db.execSQL("DROP TABLE IF EXISTS carrito")
        onCreate(db)
    }

    fun agregar(nombre: String, precio: String) {
        val db = writableDatabase
        val cv = ContentValues().apply {
            put("nombre", nombre)
            put("precio", precio)
        }
        db.insert("carrito", null, cv)
    }

    fun obtener(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM carrito", null)
    }
}
