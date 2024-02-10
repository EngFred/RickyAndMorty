package com.engineerfred.kotlin.core.feature_api

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerGraph(
        navController: NavHostController,
        navBuilder: NavGraphBuilder
    )
}