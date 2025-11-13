package com.example.hangul.model

data class Lesson(
    val id: String,
    val title: String,
    val description: String
)

data class QuizItem(
    val prompt: String,        // "ㄱ+ㅏ = ?"
    val choices: List<String>, // ["가","갸","거","고"]
    val answerIndex: Int
)