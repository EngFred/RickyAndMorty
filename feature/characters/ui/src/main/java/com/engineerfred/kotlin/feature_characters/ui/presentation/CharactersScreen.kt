package com.engineerfred.kotlin.feature_characters.ui.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.engineerfred.kotlin.core.common.Graph
import com.engineerfred.kotlin.core.common.Route
import com.engineerfred.kotlin.feature_characters.ui.components.CharactersList

@Composable
internal fun CharactersScreen(
    navController: NavHostController
) {

    val charactersViewModel: CharactersViewModel = hiltViewModel()
    val characters = charactersViewModel.characters.collectAsLazyPagingItems()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when( characters.loadState.refresh ) {
            is LoadState.Loading -> {
                CircularProgressIndicator( modifier = Modifier.size(58.dp), color = Color.Magenta )
            }
            is LoadState.Error -> {
                val error = (characters.loadState.refresh as LoadState.Error).error
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Whoops! something has gone wrong!\n $error.",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(horizontal = 20.dp),
                        textAlign = TextAlign.Center
                    )
                    Box(modifier = Modifier.fillMaxWidth().padding(top = 11.dp), contentAlignment = Alignment.Center) {
                        OutlinedButton(
                            onClick = { characters.refresh() },
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Try again",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            is LoadState.NotLoading -> {
                CharactersList(characters = characters, onCardClick = {
                    navController.navigate("${Route.CharacterDetailsScreen.destination}/${it}"){
                        popUpTo(Graph.CharacterDetails.name)
                        launchSingleTop = true
                    }
                })
            }
        }
    }
}