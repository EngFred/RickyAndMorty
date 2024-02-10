package com.engineerfred.kotlin.feature_characters.domain

import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke() = charactersRepository.getCharacters()
}