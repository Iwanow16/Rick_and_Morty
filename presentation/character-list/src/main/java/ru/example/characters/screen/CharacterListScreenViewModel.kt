package ru.example.characters.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.example.characters.mapper.toCharacterUi
import ru.example.characters.model.CharacterUi
import ru.example.domain.usecases.GetCharactersUseCase
import javax.inject.Inject

internal sealed interface CharacterListScreenUiEvent {
    data object LoadNextPage : CharacterListScreenUiEvent
}

internal sealed interface CharacterListScreenUiState {
    data class Content(val characters: List<CharacterUi>) : CharacterListScreenUiState
    data object Loading : CharacterListScreenUiState
    data class Error(val error: String) : CharacterListScreenUiState
}

@HiltViewModel
internal class CharacterListScreenViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<CharacterListScreenUiState> =
        MutableStateFlow(CharacterListScreenUiState.Loading)
    val uiState: StateFlow<CharacterListScreenUiState> = _uiState.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = CharacterListScreenUiState.Loading
        )

    fun handleEvent(event: CharacterListScreenUiEvent) {
        when (event) {
            CharacterListScreenUiEvent.LoadNextPage -> loadNextPage()
        }
    }

    private fun loadNextPage() {
        viewModelScope.launch(Dispatchers.IO) {

            getCharactersUseCase(page = 0)
                .onSuccess { characters ->
                    _uiState.update {
                        CharacterListScreenUiState.Content(
                            characters = characters.map { it.toCharacterUi() },
                        )
                    }
                }
                .onFailure { exception ->
                    _uiState.update {
                        CharacterListScreenUiState.Error(exception.message.toString())
                    }
                }
        }
    }
}