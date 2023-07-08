package com.islachin.luis.geniustec.curso

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("datos")
    suspend fun getCursos(): List<Curso>
}
