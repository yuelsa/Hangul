package com.example.hangul.ui.theme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goAlphabet: () -> Unit,
    goLab: () -> Unit,
    goGrammar: () -> Unit,
    goQuiz: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("한글 배우기 🧸") }) }
    ) { inner ->
        Column(
            modifier = Modifier.fillMaxSize().padding(inner).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BearMascot(title = "한글 배우기", subtitle = "Learn Hangul, step by step")
            Text("Start here: alphabet → syllables → grammar → quiz")
            Button(onClick = goAlphabet, modifier = Modifier.fillMaxWidth()) { Text("한글 = Hangul Alphabet") }
            Button(onClick = goLab, modifier = Modifier.fillMaxWidth()) { Text("Syllable Lab") }
            Button(onClick = goGrammar, modifier = Modifier.fillMaxWidth()) { Text("Basic Grammar") }
            Button(onClick = goQuiz, modifier = Modifier.fillMaxWidth()) { Text("Quick Quiz") }
        }
    }
}