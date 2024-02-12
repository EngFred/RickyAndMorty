package com.engineerfred.kotlin.feature_characters.data.mapper

import com.engineerfred.kotlin.feature_characters.domain.model.Character
import com.engineerfred.kotlin.core.network.CharacterDTO

fun CharacterDTO.toCharacter() : Character {

    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = origin.toDomainCharacterOrigin(),
        location = location.toDomainCharacterLocation(),
        imageUrl = image,
        episodeUrls = episode
    )
}

fun CharacterDTO.Origin.toDomainCharacterOrigin() : Character.Origin {
    return Character.Origin(
        name = name
    )
}

fun CharacterDTO.Location.toDomainCharacterLocation() : Character.Location {
    return Character.Location(
        name = name
    )
}