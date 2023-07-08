package com.islachin.luis.geniustec.horario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.islachin.luis.geniustec.R
import com.islachin.luis.geniustec.calendario.CalendarioActivity
import com.islachin.luis.geniustec.curso.CursoActivity
import com.islachin.luis.geniustec.menu.MenuActivity
import com.islachin.luis.geniustec.nota.NotaActivity

class HorarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horario)


        // Acceder a los elementos del XML
        val homeBtn = findViewById<LinearLayout>(R.id.homeBtn)
        val horario = findViewById<LinearLayout>(R.id.horarioid)
        val curso = findViewById<LinearLayout>(R.id.curso_btn)
        val nota = findViewById<LinearLayout>(R.id.notaid)
        val calendario = findViewById<LinearLayout>(R.id.calendarioid)

        // Agregar funcionalidad a los botones
        homeBtn.setOnClickListener {
            // Acción cuando se hace clic en el botón de inicio
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        horario.setOnClickListener {
            // Acción cuando se hace clic en el botón de horario
            val intent = Intent(this, HorarioActivity::class.java)
            startActivity(intent)
        }

        curso.setOnClickListener {
            // Acción cuando se hace clic en el botón de cursos
            val intent = Intent(this, CursoActivity::class.java)
            startActivity(intent)
        }

        nota.setOnClickListener {
            // Acción cuando se hace clic en el botón de notas
            val intent = Intent(this, NotaActivity::class.java)
            startActivity(intent)
        }

        calendario.setOnClickListener {
            // Acción cuando se hace clic en el botón de calendario
            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }
    }
}