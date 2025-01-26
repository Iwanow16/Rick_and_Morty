package ru.example.characters.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun CharacterListScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: CharacterListScreenViewModel = hiltViewModel<CharacterListScreenViewModel>(),
    navigateToDetailsScreen: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CharacterListScreen(
        modifier = modifier,
        uiState = uiState,
        onCharacterClick = { navigateToDetailsScreen() },
        onLoadMore = { viewModel.handleEvent(UiEvent.LoadNextPage) }
    )
}