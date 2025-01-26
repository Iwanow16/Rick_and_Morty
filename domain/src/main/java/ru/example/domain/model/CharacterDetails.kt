package ru.example.domain.model

data class CharacterDetails(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val episode: List<Int>,
    val location: String,
    val imageUrl: String,
)