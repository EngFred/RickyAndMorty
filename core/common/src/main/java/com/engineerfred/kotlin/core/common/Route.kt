package com.engineerfred.kotlin.core.common

sealed class Route ( val destination: String ) {
    data object CharactersScreen: Route("characters")
    data object SearchScreen: Route("search")
    data object CharacterDetailsScreen: Route("character_details")
}

enum class Graph{
    Characters,
    CharacterDetails,
    Search
}