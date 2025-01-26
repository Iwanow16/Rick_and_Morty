package ru.example.rick_and_morty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.example.characters.screen.navigation.CHARACTER_LIST_SCREEN_ROUTE
import ru.example.characters.screen.navigation.characterListScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CHARACTER_LIST_SCREEN_ROUTE
    ) {
        characterListScreen(
            navigateToDetailsScreen = {
                TODO("Create character-details screen")
            }
        )
    }
}