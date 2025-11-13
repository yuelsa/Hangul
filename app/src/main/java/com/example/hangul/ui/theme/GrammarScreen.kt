package com.example.hangul.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


import com.example.hangul.data.BASIC_GRAMMAR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrammarScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Basic Grammar") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }
            )
        }
    ) { inner ->
        LazyColumn(Modifier.padding(inner).padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(BASIC_GRAMMAR) { g ->
                Card {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(g.title, fontWeight = FontWeight.Bold)
                        Text(g.body)
                        Divider()
                        g.examples.forEach { ex -> Text("• $ex") }
                    }
                }
            }
        }
    }
}