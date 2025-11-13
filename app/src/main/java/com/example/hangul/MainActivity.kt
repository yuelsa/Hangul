package com.example.hangul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hangul.ui.theme.HangulTheme



import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.hangul.ui.theme.AlphabetScreen
import com.example.hangul.ui.theme.GrammarScreen
import com.example.hangul.ui.theme.HomeScreen
import com.example.hangul.ui.theme.QuizScreen
import com.example.hangul.ui.themeimport.SyllableLabScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HangulTheme {
                val nav = rememberNavController()
                NavHost(navController = nav, startDestination = "home") {
                    composable("home") {
                        HomeScreen (
                            goAlphabet = { nav.navigate("한글 = Hangul Alphabet") },
                            goLab = { nav.navigate("lab") },
                            goGrammar = { nav.navigate("grammar") },
                            goQuiz = { nav.navigate("quiz") }
                        )
                    }
                    composable("한글 = Hangul Alphabet") { AlphabetScreen (onBack = { nav.popBackStack() }) }
                    composable("lab") { SyllableLabScreen (onBack = { nav.popBackStack() }) }
                    composable("grammar") { GrammarScreen (onBack = { nav.popBackStack() }) }
                    composable("quiz") { QuizScreen (onBack = { nav.popBackStack() }) }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        HangulTheme {
            Greeting("Android")
        }
    }
}