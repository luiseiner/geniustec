package com.islachin.luis.geniustec.curso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.islachin.luis.geniustec.R
import com.islachin.luis.geniustec.calendario.CalendarioActivity
import com.islachin.luis.geniustec.horario.HorarioActivity
import com.islachin.luis.geniustec.menu.MenuActivity
import com.islachin.luis.geniustec.nota.NotaActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class CursoActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var cursoAdapter: CursoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curso)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/luiseiner/Api_cursos") // Reemplaza con la URL de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val cursos = withContext(Dispatchers.IO) {
                    apiService.getCursos()
                }
                cursoAdapter = CursoAdapter(cursos)
                recyclerView.adapter = cursoAdapter
            } catch (e: Exception) {
                Log.e("CursoActivity", "Error al obtener los cursos: ${e.message}")
            }
        }




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
