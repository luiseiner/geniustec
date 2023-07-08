package com.islachin.luis.geniustec.login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("http://127.0.0.1:8000/api/usuarios/") // Reemplaza "ruta-de-inicio-de-sesion/" con la ruta real de tu API
    fun login(@Body loginData: LoginData): Call<LoginResponse>
}