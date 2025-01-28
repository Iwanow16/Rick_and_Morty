package ru.example.character_details.mapper

import ru.example.character_details.model.CharacterDetailsUi
import ru.example.domain.model.CharacterDetails

fun CharacterDetails.toCharacterUi(): CharacterDetailsUi =
    CharacterDetailsUi(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin,
        episode = episode,
        location = location,
        imageUrl = imageUrl
    )