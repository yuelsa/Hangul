package com.example.hangul.ui.themeimport

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth

import com.example.hangul.model.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyllableLabScreen(onBack: () -> Unit) {

    val scroll = rememberScrollState()

    var c by remember { mutableStateOf("ㄱ") }
    var v by remember { mutableStateOf("ㅏ") }
    var t by remember { mutableStateOf("") }
    var output by remember { mutableStateOf(composeSyllable(c, v, t)) }
    fun recalc() {
        output = composeSyllable(c, v, t)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Syllable Lab") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .verticalScroll(scroll)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Pick initial(초성) + vowel(중성) + final(종성)", fontWeight = FontWeight.Bold)

            Text("Initial Consonant (초성)")
            ChipGridRow(
                items = CHOSEONG,
                selected = c,
                onSelect = { c = it; recalc() },
                perRow = 7
            )

            Text("Vowel (중성)")
            ChipGridRow(
                items = JUNGSEONG,
                selected = v,
                onSelect = { v = it; recalc() },
                perRow = 7
            )

            Text("Final (종성, 받침) — empty means no final")
            ChipGridRow(
                items = BASIC_FINALS.map { if (it.isEmpty()) "—" else it },
                selected = if (t.isEmpty()) "—" else t,
                onSelect = { t = if (it == "—") "" else it; recalc() },
                perRow = 8
            )

            Divider()
            Text("Result", fontWeight = FontWeight.Bold)
            Text(output, style = MaterialTheme.typography.displayMedium)

            Text("Examples")
            Text("ㄱ + ㅏ + — = 가")
            Text("ㄱ + ㅏ + ㄱ = 각")
            Text("ㅂ + ㅗ + — = 보 / ㅂ + ㅗ + ㅇ = 봉")
        }
    }
}

@Composable
private fun ChipGridRow(
    items: List<String>,
    selected: String,
    onSelect: (String) -> Unit,
    perRow: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items.chunked(perRow).forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { label ->
                    FilterChip(
                        selected = (label == selected),
                        onClick = { onSelect(label) },
                        label = { Text(label) }
                    )
                }
            }
        }
    }
}