package com.engineerfred.kotlin.rickymortyfinale.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(
    val icon: ImageVector,
    val label: String,
    val destinationScreen: String
)