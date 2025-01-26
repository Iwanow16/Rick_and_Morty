package ru.example.characters.screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.example.characters.screen.CharacterListScreenRoute

const val CHARACTER_LIST_SCREEN_ROUTE = "character_list_screen"

fun NavController.navigateToCharacterList() = navigate(CHARACTER_LIST_SCREEN_ROUTE) {
    popUpTo(CHARACTER_LIST_SCREEN_ROUTE) {
        inclusive = true
    }
}

fun NavGraphBuilder.characterListScreen(
    navigateToDetailsScreen: () -> Unit
) {
    composable(route = CHARACTER_LIST_SCREEN_ROUTE) {
        CharacterListScreenRoute(navigateToDetailsScreen = navigateToDetailsScreen)
    }
}