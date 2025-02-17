package com.olgunyilmaz.programmingjokesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olgunyilmaz.programmingjokesapp.model.Joke

@Composable
fun JokeRow(joke: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, color = Color.Cyan),
    ) {
        Text(
            text = joke,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.width(8.dp)
            .padding(5.dp))
    }

}

@Composable
fun JokeList(jokes: MutableState<List<Joke>>) {
    LazyColumn(
        modifier = Modifier
            .padding(22.dp)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(jokes.value) {
            if (it.type == "single") {
                it.joke?.let {
                    JokeRow(it)
                }

            } else {
                if (it.setup != null && it.delivery != null) {
                    val mergedJoke = it.setup + "\n" + it.delivery
                    JokeRow(mergedJoke)
                }
            }

        }


    }

}