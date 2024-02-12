package com.engineerfred.kotlin.feature_characters.data.di

import com.engineerfred.kotlin.feature_characters.domain.repo.CharactersRepository
import com.engineerfred.kotlin.core.network.KtorClient
import com.engineerfred.kotlin.feature_characters.data.repo.CharactersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharactersDataModule {

    @Provides
    @Singleton
    fun providesHomeRepository( ktorClient: KtorClient) : CharactersRepository =
        CharactersRepositoryImpl( ktorClient )
}