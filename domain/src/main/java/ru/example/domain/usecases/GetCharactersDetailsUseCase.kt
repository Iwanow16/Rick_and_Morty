package ru.example.domain.usecases

import ru.example.domain.model.CharacterDetails
import ru.example.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharactersDetailsUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(id: Long): Result<CharacterDetails> {
        return try {
            Result.success(characterRepository.getCharacterDetails(id = id))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}