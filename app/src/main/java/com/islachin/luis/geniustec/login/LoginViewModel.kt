package com.islachin.luis.geniustec.login

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.islachin.luis.geniustec.menu.MenuActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val loginService: LoginService

    val nombres = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginResult = MutableLiveData<Boolean>()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8000/api/usuarios/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        loginService = retrofit.create(LoginService::class.java)
    }

    fun login() {
        val usernameValue = nombres.value
        val passwordValue = password.value

        if (usernameValue != null && passwordValue != null) {
            // Realizar la solicitud de inicio de sesión en una corutina
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    val response = withContext(Dispatchers.IO) {
                        loginService.login(LoginData(usernameValue, passwordValue)).execute()
                    }

                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        // Verificar la respuesta del inicio de sesión
                        if (loginResponse != null) {
                            // Inicio de sesión exitoso
                            loginResult.value = true

                            // Redirigir a la actividad MenuActivity
                            val intent = Intent(getApplication(), MenuActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            getApplication<Application>().startActivity(intent)
                            Log.d("LoginViewModel", "Respuesta de inicio de sesión: $loginResponse")
                        } else {
                            // Inicio de sesión fallido
                            loginResult.value = false
                        }
                    } else {
                        // Inicio de sesión fallido
                        loginResult.value = false
                    }
                } catch (e: Exception) {
                    // Manejar errores de conexión u otros errores
                    loginResult.value = false

                }
            }
        } else {
            // Manejar el caso cuando los valores de usuario y contraseña son nulos
            loginResult.value = false
        }
    }


}

