package com.islachin.luis.geniustec.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.islachin.luis.geniustec.R
import com.islachin.luis.geniustec.menu.MenuActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Observa los cambios en las propiedades observables y actualiza los elementos de diseño en consecuencia
//        viewModel.nombres.observe(this, { nombres ->
//            val usernameEditText = findViewById<EditText>(R.id.textname)
//            usernameEditText.setText(nombres)
//        })
//
//        viewModel.password.observe(this, { password ->
//            val passwordEditText = findViewById<EditText>(R.id.textpassword)
//            passwordEditText.setText(password)
//        })

        val btnInicio = findViewById<Button>(R.id.btn_inicio)
        btnInicio.setOnClickListener {
//            val nombresEditText = findViewById<EditText>(R.id.textname)
//            val passwordEditText = findViewById<EditText>(R.id.textpassword)
//
//            viewModel.nombres.value = nombresEditText.text.toString()
//            viewModel.password.value = passwordEditText.text.toString()
//            viewModel.login()

            // Redirige directamente a MenuActivity sin realizar validaciones adicionales
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish() // Opcional, si deseas cerrar LoginActivity después de redirigir
        }

//        viewModel.loginResult.observe(this, { loginSuccessful ->
//            if (loginSuccessful) {
//                val intent = Intent(this, MenuActivity::class.java)
//                startActivity(intent)
//                finish() // Opcional, si deseas cerrar LoginActivity después de redirigir
//            } else {
//                // Inicio de sesión fallido, muestra un mensaje de error
//            }
//        })

    }
}
