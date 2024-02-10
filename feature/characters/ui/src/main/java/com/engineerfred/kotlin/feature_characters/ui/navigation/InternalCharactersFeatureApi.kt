package com.engineerfred.kotlin.feature_characters.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.engineerfred.kotlin.core.common.Graph
import com.engineerfred.kotlin.core.common.Route
import com.engineerfred.kotlin.core.feature_api.FeatureApi
import com.engineerfred.kotlin.feature_characters.ui.CharactersScreen

internal object InternalCharactersFeatureApi : FeatureApi {

    override fun registerGraph(
        navController: NavHostController,
        navBuilder: NavGraphBuilder
    ) {
        navBuilder.navigation(
            startDestination = Route.CharactersScreen.destination,
            route = Graph.Characters.name
        ) {
            composable( route = Route.CharactersScreen.destination ) {
                CharactersScreen()
            }
        }
    }
}