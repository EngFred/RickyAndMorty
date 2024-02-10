package com.engineerfred.kotlin.feature_characters.data

import com.engineerfred.kotlin.feature_characters.domain.DomainCharacter
import com.engineerfred.kotlin.core.network.CharacterDTO

fun CharacterDTO.toCharacter() : DomainCharacter {

    return DomainCharacter(
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

fun CharacterDTO.Origin.toDomainCharacterOrigin() : DomainCharacter.Origin {
    return DomainCharacter.Origin(
        name = name
    )
}

fun CharacterDTO.Location.toDomainCharacterLocation() : DomainCharacter.Location {
    return DomainCharacter.Location(
        name = name
    )
}