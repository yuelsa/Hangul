package com.example.hangul.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import com.example.hangul.model.QuizItem


private val QUIZ = listOf(
    QuizItem(prompt = "ㄱ + ㅏ = ?", choices = listOf("가","갸","거","고"), answerIndex = 0),
    QuizItem(prompt = "ㅈ + ㅣ = ?", choices = listOf("저","지","죠","주"), answerIndex = 1),
    QuizItem(prompt = "ㅂ + ㅗ = ?", choices = listOf("보","버","바","부"), answerIndex = 0),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(onBack: () -> Unit) {
    var idx by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    val item = QUIZ.getOrNull(idx)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quick Quiz") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }
            )
        }
    ) { inner ->
        Column(Modifier.padding(inner).padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("Score: $score / ${QUIZ.size}")
            if (item == null) {
                Text("Done! 🎉")
                Button(onClick = { idx = 0; score = 0 }) { Text("Restart") }
            } else {
                Text(item.prompt, style = MaterialTheme.typography.titleLarge)
                item.choices.forEachIndexed { i, c ->
                    Button(
                        onClick = {
                            if (i == item.answerIndex) score++
                            idx++
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text(c) }
                }
            }
        }
    }
}