package ru.example.rick_and_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import ru.example.rick_and_morty.navigation.Navigation
import ru.example.ui_kit.ui.theme.Rick_and_MortyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Rick_and_MortyTheme(dynamicColor = false) {
                Navigation()
            }
        }
    }
}