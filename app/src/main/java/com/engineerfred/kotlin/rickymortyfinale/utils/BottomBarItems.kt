package com.engineerfred.kotlin.rickymortyfinale.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import com.engineerfred.kotlin.core.common.Route
import com.engineerfred.kotlin.rickymortyfinale.model.BottomBarItem

val bottomBarItems = listOf(
    BottomBarItem(
        icon = Icons.Rounded.Home,
        label = "Home",
        destinationScreen = Route.CharactersScreen.destination
    ),
    BottomBarItem(
        icon = Icons.Rounded.Search,
        label = "Search",
        destinationScreen = Route.SearchScreen.destination
    )
)