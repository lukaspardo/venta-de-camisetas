
package com.tuempresa.camisetas.activities

import android.database.Cursor
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tuempresa.camisetas.R
import com.tuempresa.camisetas.database.DBHelper

class CarritoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        val txt = findViewById<TextView>(R.id.txtCarrito)
        val db = DBHelper(this)
        val c: Cursor = db.obtener()

        var datos = ""
        while (c.moveToNext()) {
            datos += "${c.getString(1)} - ${c.getString(2)}\n"
        }

        txt.text = datos
    }
}
