package com.engineerfred.kotlin.rickymortyfinale.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.engineerfred.kotlin.core.common.Graph
import com.engineerfred.kotlin.rickymortyfinale.utils.NavigationProvider

@Composable
fun MainAppNavigationGraph(
    modifier: Modifier = Modifier,
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

        navigationProvider.searchApi.registerGraph(
            navController, this
        )

        navigationProvider.characterDetailsApi.registerGraph(
            navController, this
        )
    }

}