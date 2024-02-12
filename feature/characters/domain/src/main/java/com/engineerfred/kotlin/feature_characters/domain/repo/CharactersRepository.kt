package com.engineerfred.kotlin.feature_characters.domain.repo

import androidx.paging.PagingData
import com.engineerfred.kotlin.feature_characters.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters() : Flow<PagingData<Character>>
}