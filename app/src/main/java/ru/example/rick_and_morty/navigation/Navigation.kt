package ru.example.rick_and_morty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.example.character_details.screen.navigation.characterDetailsScreen
import ru.example.character_details.screen.navigation.navigateToDetails
import ru.example.characters_list.screen.navigation.CHARACTER_LIST_SCREEN_ROUTE
import ru.example.characters_list.screen.navigation.characterListScreen
import ru.example.characters_list.screen.navigation.navigateToList

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CHARACTER_LIST_SCREEN_ROUTE
    ) {
        characterListScreen(
            navigateToDetailsScreen = {
                navController.navigateToDetails(it)
            }
        )

        characterDetailsScreen(
            navigateToListScreen = {
                navController.navigateToList()
            }
        )
    }
}