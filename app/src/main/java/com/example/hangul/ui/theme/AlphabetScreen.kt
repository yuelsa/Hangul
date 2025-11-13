package com.example.hangul.ui.theme

import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.hangul.model.BASIC_CONSONANTS
import com.example.hangul.model.BASIC_VOWELS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlphabetScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("한글 = Hangul Alphabet") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }
            )
        }
    ) { inner ->
        LazyColumn(
            modifier = Modifier.padding(inner).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text("Consonants (자음)", fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                AssistChipGrid(items = BASIC_CONSONANTS, perRow = 7)
            }

            item {
                Spacer(Modifier.height(8.dp))
                Text("Vowels (모음)", fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                AssistChipGrid(items = BASIC_VOWELS, perRow = 5)
            }

            item {
                Spacer(Modifier.height(16.dp))
                Text("Tip: Hangul syllables are made from Consonant(초성) + Vowel(중성) (+ Final consonant 종성).")
            }
        }
    }
}


@Composable
private fun AssistChipGrid(
    items: List<String>,
    perRow: Int,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items.chunked(perRow).forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { label ->
                    AssistChip(onClick = { onClick(label) }, label = { Text(label) })
                }
            }
        }
    }
}