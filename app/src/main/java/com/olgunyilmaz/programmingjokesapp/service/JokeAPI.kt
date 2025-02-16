package com.olgunyilmaz.programmingjokesapp.service

import retrofit2.http.GET
import com.olgunyilmaz.programmingjokesapp.model.Joke

interface JokeAPI {

    @GET("atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json")
    fun fetchData(): List<Joke>

}