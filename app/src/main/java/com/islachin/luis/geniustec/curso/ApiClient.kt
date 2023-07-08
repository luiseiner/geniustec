package com.islachin.luis.geniustec.curso

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://demo4714913.mockable.io/curso") // Reemplaza con la URL base de tu API
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}
