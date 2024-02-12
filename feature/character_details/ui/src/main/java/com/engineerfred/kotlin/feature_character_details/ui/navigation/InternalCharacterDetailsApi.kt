package com.engineerfred.kotlin.feature_character_details.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.engineerfred.kotlin.core.common.Graph
import com.engineerfred.kotlin.core.common.Route
import com.engineerfred.kotlin.core.feature_api.FeatureApi
import com.engineerfred.kotlin.feature_character_details.ui.presentation.CharacterDetailsScreen

object InternalCharacterDetailsApi: FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navBuilder: NavGraphBuilder
    ) {
       navBuilder.navigation(
           startDestination = Route.CharacterDetailsScreen.destination,
           route = Graph.CharacterDetails.name
       ) {
           composable(
               route = "${Route.CharacterDetailsScreen.destination}/{characterId}",
               arguments = listOf(
                   navArgument( name = "characterId" ) {
                       type = NavType.LongType
                   }
               )
           ) {
               val characterId = it.arguments?.getLong("characterId")!!
               CharacterDetailsScreen(characterId = characterId)
           }
       }
    }
}