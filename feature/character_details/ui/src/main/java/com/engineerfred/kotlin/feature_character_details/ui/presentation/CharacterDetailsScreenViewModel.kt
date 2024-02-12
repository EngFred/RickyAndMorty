package com.engineerfred.kotlin.feature_character_details.ui.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val characterId = savedStateHandle.getStateFlow("characterId", 1L)

    companion object {
        const val TAG = "CharacterDetailsScreenViewModel"
    }

    init {
        viewModelScope.launch( Dispatchers.IO ) {
            characterId.collectLatest {
                Log.i(TAG, "Received id is $it!")
                //Todo("Get character details")
            }
        }
    }

}