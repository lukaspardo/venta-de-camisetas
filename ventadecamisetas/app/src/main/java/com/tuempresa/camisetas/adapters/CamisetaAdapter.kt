
package com.tuempresa.camisetas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.tuempresa.camisetas.R
import com.tuempresa.camisetas.database.DBHelper
import com.tuempresa.camisetas.models.Camiseta

class CamisetaAdapter(
    private val lista: List<Camiseta>,
    private val context: Context
) : RecyclerView.Adapter<CamisetaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_camiseta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val c = lista[position]
        holder.img.setImageResource(c.imagen)
        holder.nombre.text = c.nombre
        holder.precio.text = c.precio

        holder.btn.setOnClickListener {
            val db = DBHelper(context)
            db.agregar(c.nombre, c.precio)
            Toast.makeText(context, "Agregado al carrito", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = lista.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgCamiseta)
        val nombre: TextView = itemView.findViewById(R.id.txtNombre)
        val precio: TextView = itemView.findViewById(R.id.txtPrecio)
        val btn: Button = itemView.findViewById(R.id.btnAgregar)
    }
}
