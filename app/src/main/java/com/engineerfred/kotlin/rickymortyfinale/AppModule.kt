package com.engineerfred.kotlin.rickymortyfinale

import com.engineerfred.kotlin.feature_characters.ui.navigation.CharactersApi
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
        charactersApi: CharactersApi
    ) = NavigationProvider(  charactersApi )
}