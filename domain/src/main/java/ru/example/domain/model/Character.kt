package ru.example.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species:String,
    val gender: String,
    val origin:String,
    val imageUrl: String,
)