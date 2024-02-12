package com.engineerfred.kotlin.feature_character_details.ui.di

import com.engineerfred.kotlin.feature_character_details.ui.navigation.CharacterDetailsApi
import com.engineerfred.kotlin.feature_character_details.ui.navigation.CharacterDetailsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsUiModule {

    @Provides
    @Singleton
    fun providesCharacterDetails() : CharacterDetailsApi
        = CharacterDetailsApiImpl()
}