package com.engineerfred.kotlin.feature_search.ui.di

import com.engineerfred.kotlin.feature_search.ui.navigation.SearchApi
import com.engineerfred.kotlin.feature_search.ui.navigation.SearchApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchUiModule {

    @Provides
    @Singleton
    fun providesSearchApi() : SearchApi = SearchApiImpl()
}