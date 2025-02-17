package com.olgunyilmaz.programmingjokesapp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.olgunyilmaz.programmingjokesapp.model.Joke
import com.olgunyilmaz.programmingjokesapp.service.JokeAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeViewModel : ViewModel() {

    private val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JokeAPI::class.java)

    val jokeList = mutableStateOf<List<Joke>>(listOf())


    fun getJokes() {
        retrofit.fetchData().enqueue(object : Callback<List<Joke>> {
            override fun onResponse(call: Call<List<Joke>>, response: Response<List<Joke>>) {
                if (response.isSuccessful) {
                    jokeList.value = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<Joke>>, t: Throwable) {
                Log.e("JokeAPI", "Error fetching jokes", t)
            }
        })
    }
}