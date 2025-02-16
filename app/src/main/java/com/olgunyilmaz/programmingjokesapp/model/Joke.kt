package com.olgunyilmaz.programmingjokesapp.model


data class Joke(
    val type : String,
    val joke : String? = null,
    val setup : String? = null,
    val delivery : String? = null,
) {
}