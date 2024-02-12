package com.engineerfred.kotlin.feature_characters.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.engineerfred.kotlin.core.network.CharactersPaginationSource
import com.engineerfred.kotlin.feature_characters.domain.repo.CharactersRepository
import com.engineerfred.kotlin.feature_characters.domain.model.Character
import com.engineerfred.kotlin.core.network.KtorClient
import com.engineerfred.kotlin.feature_characters.data.mapper.toCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val ktorClient: KtorClient
) : CharactersRepository {

    override fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig( pageSize = 10, initialLoadSize = 20 ),
            pagingSourceFactory = { CharactersPaginationSource(ktorClient) }
        ).flow.map {
            it.map {
                it.toCharacter()
            }
        }.flowOn(Dispatchers.IO)
    }

}

/*
initialLoadSize:
This parameter determines the initial number of items to load into the RecyclerView
when the data is first loaded or when the dataset is invalidated.
It represents the size of the initial chunk of data that is loaded from your data source.

pageSize: This parameter determines the size of subsequent pages that are loaded
 as the user scrolls through the dataset.
 It represents the number of items to load in each page after the initial load.
 */