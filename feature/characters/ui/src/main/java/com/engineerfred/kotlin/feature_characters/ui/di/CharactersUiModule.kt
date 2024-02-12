package com.engineerfred.kotlin.feature_characters.ui.di

import com.engineerfred.kotlin.feature_characters.ui.navigation.CharactersApi
import com.engineerfred.kotlin.feature_characters.ui.navigation.CharactersApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharactersUiModule {

    @Provides
    @Singleton
    fun providesCharactersApi() : CharactersApi =
        CharactersApiImpl()

}