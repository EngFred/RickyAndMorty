package com.engineerfred.kotlin.rickymortyfinale.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.engineerfred.kotlin.rickymortyfinale.presentation.components.MainAppNavigationGraph
import com.engineerfred.kotlin.rickymortyfinale.utils.NavigationProvider
import com.engineerfred.kotlin.rickymortyfinale.presentation.components.BottomBar

@Composable
fun App(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainAppNavigationGraph(
                modifier = Modifier.padding(it),
                navController = navController,
                navigationProvider = navigationProvider
            )
        }
    }

}