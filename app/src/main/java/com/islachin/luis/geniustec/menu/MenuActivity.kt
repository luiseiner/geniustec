package com.islachin.luis.geniustec.menu


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.islachin.luis.geniustec.R
import com.islachin.luis.geniustec.comentario.ComentarioActivity
import com.islachin.luis.geniustec.curso.CursoActivity
import com.islachin.luis.geniustec.horario.HorarioActivity
import com.islachin.luis.geniustec.nota.NotaActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val layoutCurso = findViewById<LinearLayout>(R.id.layout_curso)
        layoutCurso.setOnClickListener {
            val intent = Intent(this, CursoActivity::class.java)
            startActivity(intent)
        }

        val layoutNota = findViewById<LinearLayout>(R.id.layout_nota)
        layoutNota.setOnClickListener {
            val intent = Intent(this, NotaActivity::class.java)
            startActivity(intent)
        }

        val layoutHorario = findViewById<LinearLayout>(R.id.layout_horario)
        layoutHorario.setOnClickListener {
            val intent = Intent(this, HorarioActivity::class.java)
            startActivity(intent)
        }

        val layoutComentario = findViewById<LinearLayout>(R.id.layout_comentario)
        layoutComentario.setOnClickListener {
            val intent = Intent(this, ComentarioActivity::class.java)
            startActivity(intent)
        }
    }
}
