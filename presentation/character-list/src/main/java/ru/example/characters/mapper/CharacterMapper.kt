package ru.example.characters.mapper

import ru.example.characters.model.CharacterUi
import ru.example.domain.model.Character

fun Character.toCharacterUi(): CharacterUi =
    CharacterUi(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = origin,
        imageUrl = imageUrl
    )