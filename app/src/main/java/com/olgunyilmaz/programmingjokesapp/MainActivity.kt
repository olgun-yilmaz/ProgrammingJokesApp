package com.olgunyilmaz.programmingjokesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olgunyilmaz.programmingjokesapp.model.Joke
import com.olgunyilmaz.programmingjokesapp.ui.theme.ProgrammingJokesAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            ProgrammingJokesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Modifier.padding(innerPadding)
                    JokeRow("hello, this is a joke.")
                }
            }
        }
    }
}


/*
Compose kullan.

Tek sayfada tüm şakaları göster.

MVMM yapısına uygun yap.

https://raw.githubusercontent.com/" BASE URL
atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json ENDPOINT
 */


@Composable
fun JokeRow(joke : String) {
    Column (modifier = Modifier.fillMaxWidth()
        .border(1.dp, color = Color.Cyan)){
        Text(
            text = joke,
        )
        Spacer(modifier = Modifier.width(8.dp))
    }

}

@Composable
fun JokeList(jokes : List<Joke>){
    LazyColumn () {
        items(jokes){
            if (it.type == "single"){
                it.joke?.let {
                    JokeRow(it)
                }

            }else{
                if (it.setup != null && it.delivery != null){
                    val mergedJoke = it.setup + "\n" + it.delivery
                    JokeRow(mergedJoke)
                }
            }

        }
        

    }

}

@Preview(showBackground = true)
@Composable
fun JokeRowPreview() {
    ProgrammingJokesAppTheme {
        val joke1 = Joke("single","this is a joke.")
        val joke2 = Joke("twopart",setup = "what is a joke?", delivery =  "this is.")
        val joke3 = Joke("single","its enough.")
        val jokes = listOf(joke3,joke2,joke1)
        JokeList(jokes)
    }
}