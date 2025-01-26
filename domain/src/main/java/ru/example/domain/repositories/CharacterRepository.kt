package ru.example.domain.repositories

import ru.example.domain.model.Character
import ru.example.domain.model.CharacterDetails

interface CharacterRepository {

    suspend fun getAllCharacters(page: Int): List<Character>

    suspend fun getCharacterDetails(id: Long): CharacterDetails
}