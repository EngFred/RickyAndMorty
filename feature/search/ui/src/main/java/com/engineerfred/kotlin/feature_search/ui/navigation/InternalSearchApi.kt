package com.engineerfred.kotlin.feature_search.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.engineerfred.kotlin.core.common.Graph
import com.engineerfred.kotlin.core.common.Route
import com.engineerfred.kotlin.core.feature_api.FeatureApi
import com.engineerfred.kotlin.feature_search.ui.presentation.SearchScreen

internal object InternalSearchApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navBuilder: NavGraphBuilder
    ) {
        navBuilder.navigation(
            startDestination = Route.SearchScreen.destination,
            route = Graph.Search.name
        ) {
            composable(
                Route.SearchScreen.destination
            ) {
                SearchScreen()
            }
        }
    }

}