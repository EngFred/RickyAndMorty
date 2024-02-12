package com.engineerfred.kotlin.rickymortyfinale.utils

import com.engineerfred.kotlin.feature_character_details.ui.navigation.CharacterDetailsApi
import com.engineerfred.kotlin.feature_characters.ui.navigation.CharactersApi
import com.engineerfred.kotlin.feature_search.ui.navigation.SearchApi

data class NavigationProvider(
    val charactersApi: CharactersApi,
    val characterDetailsApi: CharacterDetailsApi,
    val searchApi: SearchApi
)