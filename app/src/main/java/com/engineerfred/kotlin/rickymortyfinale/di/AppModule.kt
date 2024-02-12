package com.engineerfred.kotlin.rickymortyfinale.di

import com.engineerfred.kotlin.feature_character_details.ui.navigation.CharacterDetailsApi
import com.engineerfred.kotlin.feature_characters.ui.navigation.CharactersApi
import com.engineerfred.kotlin.feature_search.ui.navigation.SearchApi
import com.engineerfred.kotlin.rickymortyfinale.utils.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNavigationProvider(
        charactersApi: CharactersApi,
        characterDetailsApi: CharacterDetailsApi,
        searchApi: SearchApi
    ) = NavigationProvider(  charactersApi, characterDetailsApi, searchApi )
}