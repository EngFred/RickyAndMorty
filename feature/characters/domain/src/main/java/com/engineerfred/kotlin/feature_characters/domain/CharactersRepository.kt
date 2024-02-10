package com.engineerfred.kotlin.feature_characters.domain

import androidx.paging.PagingData
import com.engineerfred.kotlin.core.common.ApiResponse
import com.engineerfred.kotlin.core.network.CharacterDTO
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters() : Flow<PagingData<DomainCharacter>>
}