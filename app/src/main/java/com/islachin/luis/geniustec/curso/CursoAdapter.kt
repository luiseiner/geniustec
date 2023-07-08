package com.islachin.luis.geniustec.curso

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.islachin.luis.geniustec.R

class CursoAdapter(private val cursos: List<Curso>) : RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_curso, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = cursos[position]
        holder.bind(curso)
    }

    override fun getItemCount(): Int {
        return cursos.size
    }

    inner class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.item_image)
        private val tituloCursoTextView: TextView = itemView.findViewById(R.id.id_titulocurso)
        private val cursoTextView: TextView = itemView.findViewById(R.id.id_curso)

        fun bind(curso: Curso) {
            // Asignar los datos a las vistas correspondientes
            tituloCursoTextView.text = curso.curso
            cursoTextView.text = curso.id

            // Configurar la imagen si es necesario
            // imageView.setImageResource(R.drawable.mi_imagen)
        }
    }
}
