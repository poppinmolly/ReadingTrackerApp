package com.example.readingtrackerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.readingtrackerapp.presentation.screens.Home.HomeScreen
import com.example.readingtrackerapp.presentation.screens.Home.HomeScreenUi
import com.example.readingtrackerapp.ui.theme.ReadingTrackerAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReadingTrackerAppTheme {
                HomeScreen()
            }
        }
    }
}

