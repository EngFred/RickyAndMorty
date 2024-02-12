package com.engineerfred.kotlin.feature_character_details.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.engineerfred.kotlin.core.feature_api.FeatureApi

interface CharacterDetailsApi : FeatureApi {
}

class CharacterDetailsApiImpl : CharacterDetailsApi {
    override fun registerGraph(
        navController: NavHostController,
        navBuilder: NavGraphBuilder
    ) {
        InternalCharacterDetailsApi.registerGraph(
            navController, navBuilder
        )
    }
}