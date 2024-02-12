package com.engineerfred.kotlin.feature_character_details.ui.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.engineerfred.kotlin.feature_character_details.ui.presentation.CharacterDetailsScreenViewModel

@Composable
internal fun CharacterDetailsScreen(
    characterId: Long
) {

    val viewModel = hiltViewModel<CharacterDetailsScreenViewModel>()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Detail Screen for a character with id $characterId!")
    }

}