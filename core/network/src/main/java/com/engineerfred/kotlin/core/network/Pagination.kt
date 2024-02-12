package com.engineerfred.kotlin.core.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

class CharactersPaginationSource @Inject constructor(
    private val ktorClient: KtorClient
) : PagingSource<Int, CharacterDTO>() {

    companion object {
        const val TAG = "CharactersPaginationSource"
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDTO>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDTO> {
        return try {
            Log.i(TAG, "Success!!!")
            val currentPage = params.key ?: 1
            val apiResponse = ktorClient.getCharacters( page = currentPage )
            val endOfPaginationReached = apiResponse.results.isEmpty()
            LoadResult.Page(
                data = apiResponse.results,
                prevKey = if ( currentPage == 1 ) null else currentPage - 1,
                nextKey = if ( endOfPaginationReached ) null else currentPage + 1
            )
        } catch (ex: Exception ) {
            Log.i(TAG, "Whoops! $ex")
            return when {
                ex is UnknownHostException -> {
                    LoadResult.Error(Throwable("Unable to connect to the server!"))
                }
                ex is ConnectException || ex.toString().contains("java.lang.Throwable") -> {
                    LoadResult.Error(Throwable("No internet connection!"))
                }
                else -> {
                    LoadResult.Error(ex)
                }
            }
        }
    }
}