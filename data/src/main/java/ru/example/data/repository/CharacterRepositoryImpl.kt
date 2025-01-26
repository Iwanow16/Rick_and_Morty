package ru.example.data.repository

import ru.example.data.sources.remote.mappers.toCharacter
import ru.example.data.sources.remote.mappers.toCharacterDetails
import ru.example.data.sources.remote.service.RickAndMortyApi
import ru.example.domain.model.Character
import ru.example.domain.model.CharacterDetails
import ru.example.domain.repositories.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterRepository {

    override suspend fun getAllCharacters(page: Int): List<Character> {
        val characters = api.getAllCharacters(page).character

        return characters.map { character ->
            character.toCharacter()
        }
    }

    override suspend fun getCharacterDetails(id: Long): CharacterDetails {
        val character = api.getCharacterDetails(id)

        return character.toCharacterDetails()
    }
}