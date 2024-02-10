package com.engineerfred.kotlin.core.network

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>
) {
    @Serializable
    data class Origin(
        val name: String
    )

    @Serializable
    data class Location(
        val name: String
    )
}
