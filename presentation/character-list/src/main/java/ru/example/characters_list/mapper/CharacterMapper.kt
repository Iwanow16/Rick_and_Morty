package ru.example.characters_list.mapper

import ru.example.characters_list.model.CharacterUi
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