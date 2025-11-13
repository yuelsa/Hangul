package com.example.hangul.data


data class GrammarPoint(
    val title: String,
    val body: String,
    val examples: List<String>
)

val BASIC_GRAMMAR = listOf(
    GrammarPoint(
        title = "Korean sentence order (SOV)",
        body = "한국어는 보통 주어–목적어–동사 순서(SOV)입니다.",
        examples = listOf("저는 사과를 먹어요.", "저는 한국어를 공부해요.")
    ),
    GrammarPoint(
        title = "Topic/subject particles: 은/는, 이/가",
        body = "은/는(주제), 이/가(주어). 받침 유무에 따라 형태가 달라집니다.",
        examples = listOf("저는 학생이에요.", "고양이가 귀여워요.")
    ),
    GrammarPoint(
        title = "Object particle: 을/를",
        body = "목적어 뒤에 붙습니다. 받침 있으면 을, 없으면 를.",
        examples = listOf("책을 읽어요.", "영화를 봐요.")
    ),
    GrammarPoint(
        title = "Polite endings: -요, -입니다",
        body = "회화체는 -요, 격식체는 -입니다/-습니다를 사용합니다.",
        examples = listOf("반가워요.", "안녕하십니까?")
    ),
    GrammarPoint(
        title = "Coping with vowels",
        body = "모음 조화와 발음은 익숙해지면 빠릅니다. 천천히, 크게 소리 내 보세요.",
        examples = listOf("아/야, 어/여, 오/요, 우/유, 으/이")
    )
)