package com.engineerfred.kotlin.feature_characters.domain

sealed class CharacterGender( val displayName: String ) {
    data object Male: CharacterGender("Male")
    data object Female: CharacterGender("Female")
    data object Genderless: CharacterGender("No gender")
    data object Unknown: CharacterGender("Not specified")
}