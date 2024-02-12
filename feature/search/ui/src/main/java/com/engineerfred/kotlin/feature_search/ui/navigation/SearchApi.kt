package com.engineerfred.kotlin.feature_search.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.engineerfred.kotlin.core.feature_api.FeatureApi

interface SearchApi : FeatureApi {
}

class SearchApiImpl : SearchApi {
    override fun registerGraph(
        navController: NavHostController,
        navBuilder: NavGraphBuilder
    ) {
        InternalSearchApi.registerGraph(
            navController, navBuilder
        )
    }
}