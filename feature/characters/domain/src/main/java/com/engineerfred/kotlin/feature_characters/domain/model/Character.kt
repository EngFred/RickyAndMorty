package com.engineerfred.kotlin.feature_characters.domain.model


data class Character(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin?,
    val location: Location?,
    val imageUrl: String,
    val episodeUrls: List<String>
) {
    data class Origin(
        val name: String
    )
    data class Location(
        val name: String
    )
}
