
package com.tuempresa.camisetas.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuempresa.camisetas.R
import com.tuempresa.camisetas.adapters.CamisetaAdapter
import com.tuempresa.camisetas.models.Camiseta

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recyclerCamisetas)
        recycler.layoutManager = LinearLayoutManager(this)

        val lista = listOf(
            Camiseta(R.drawable.madrid, "Real Madrid 24/25", "$180.000"),
            Camiseta(R.drawable.barcelona, "Barcelona 24/25", "$170.000"),
            Camiseta(R.drawable.colombia, "Colombia 24/25", "$160.000")
        )

        recycler.adapter = CamisetaAdapter(lista, this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_carrito, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, CarritoActivity::class.java))
        return true
    }
}
