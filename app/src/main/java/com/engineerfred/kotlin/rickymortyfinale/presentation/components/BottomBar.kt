package com.engineerfred.kotlin.rickymortyfinale.presentation.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.engineerfred.kotlin.rickymortyfinale.utils.bottomBarItems

@Composable
fun BottomBar(
    navController: NavHostController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    if ( bottomBarItems.any { it.destinationScreen == currentDestination?.route } ) {
        BottomAppBar(actions = {
            bottomBarItems.forEach{ bottomBarItem ->
                NavigationBarItem(
                    selected = currentDestination?.route == bottomBarItem.destinationScreen,
                    onClick = {
                        navController.navigate( bottomBarItem.destinationScreen ) {
                            popUpTo( navController.graph.findStartDestination().id ){ saveState =  true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = bottomBarItem.icon,
                            contentDescription = bottomBarItem.label
                        )
                    },
                    label = { Text(text = bottomBarItem.label) }
                )
            }
        })
    }
}
