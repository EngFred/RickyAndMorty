package com.engineerfred.kotlin.feature_characters.domain

import androidx.compose.ui.graphics.Color


sealed class CharacterStatus(val displayName: String, val color: Color) {
    data object Alive: CharacterStatus("Alive", Color.Green )
    data object Dead: CharacterStatus("Dead", Color.Red )
    data object Unknown: CharacterStatus("Not specified", Color.Magenta)
}
