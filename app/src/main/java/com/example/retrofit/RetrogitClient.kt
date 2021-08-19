package com.example.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
class RetrogitClient private constructor() {
    companion object {
        private lateinit var retrofit: Retrofit
        private val baseUrl = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofiInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder()
            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder().baseUrl(baseUrl).client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
        fun <S>createService(serviceClass: Class<S>): S{
            return getRetrofiInstance().create(serviceClass)
        }
    }
}