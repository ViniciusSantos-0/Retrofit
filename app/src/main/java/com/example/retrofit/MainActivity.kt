package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote = RetrogitClient.createService(PostService::class.java)
        val call: Call<List<PostModel>> = remote.list()

        // val response = call.execute() // Sincrona

        val response = call.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, ress: Response<List<PostModel>>) {
                val s = ress.body()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val s = t.message
            }

        })  //Assicrona

    }
}