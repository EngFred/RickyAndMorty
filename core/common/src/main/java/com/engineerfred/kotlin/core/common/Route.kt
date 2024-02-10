package com.engineerfred.kotlin.core.common

sealed class Route ( val destination: String ) {
    data object CharactersScreen: Route("characters")
}

enum class Graph{
    Characters
}