package com.engineerfred.kotlin.feature_characters.domain.use_cases

import com.engineerfred.kotlin.feature_characters.domain.repo.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke() = charactersRepository.getCharacters()
}