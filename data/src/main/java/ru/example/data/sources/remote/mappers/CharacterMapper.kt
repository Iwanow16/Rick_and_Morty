package ru.example.data.sources.remote.mappers

import ru.example.data.sources.remote.models.characters.CharacterDto
import ru.example.domain.model.Character
import ru.example.domain.model.CharacterDetails

fun CharacterDto.toCharacter(): Character =
    Character(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = originDto.name,
        imageUrl = image
    )

fun CharacterDto.toCharacterDetails(): CharacterDetails =
    CharacterDetails(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = originDto.name,
        episode = episode,
        location = locationDto.name,
        imageUrl = image
    )
