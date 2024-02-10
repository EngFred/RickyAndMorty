package com.engineerfred.kotlin.rickymortyfinale

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.engineerfred.kotlin.core.common.Graph

@Composable
fun MainAppNavigationGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {

    NavHost(
        navController = navController,
        startDestination = Graph.Characters.name
    ) {

        navigationProvider.charactersApi.registerGraph(
            navController, this
        )
    }

}