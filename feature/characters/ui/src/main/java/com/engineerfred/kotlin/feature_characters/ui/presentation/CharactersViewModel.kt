package com.engineerfred.kotlin.feature_characters.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.engineerfred.kotlin.feature_characters.domain.model.Character
import com.engineerfred.kotlin.feature_characters.domain.use_cases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _characters = MutableStateFlow<PagingData<Character>>( PagingData.empty() )
    val characters = _characters.asStateFlow()

    companion object {
        const val TAG = "CharactersViewModel"
    }

    init {
        getCharacters()
    }

    private fun getCharacters() = viewModelScope.launch {
        getCharactersUseCase.invoke()
            .cachedIn(viewModelScope)
            .collect{
            _characters.value = it
        }
    }

}