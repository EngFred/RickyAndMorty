package com.engineerfred.kotlin.feature_characters.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.engineerfred.kotlin.core.feature_api.FeatureApi

interface CharactersApi : FeatureApi {
}

class CharactersApiImpl : CharactersApi {
    override fun registerGraph(
        navController: NavHostController,
        navBuilder: NavGraphBuilder
    ) {
        InternalCharactersFeatureApi.registerGraph(
            navController, navBuilder
        )
    }
}