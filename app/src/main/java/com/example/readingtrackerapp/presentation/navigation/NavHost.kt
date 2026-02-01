package com.example.readingtrackerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.readingtrackerapp.presentation.screens.Explore.ExploreScreen
import com.example.readingtrackerapp.presentation.screens.Explore.ExploreScreenUi
import com.example.readingtrackerapp.presentation.screens.Home.HomeTabScreen
import com.example.readingtrackerapp.presentation.screens.Profile.ProfileScreen
import com.example.readingtrackerapp.presentation.screens.Reading.ReadingScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier,
){
    NavHost(
        navController, startDestination = startDestination.route, modifier = modifier
    ){
        Destination.entries.forEach { destination ->
            composable(destination.route){
                when (destination){
                    Destination.HOME -> {
                        HomeTabScreen()
                    }
                    Destination.EXPLORE -> ExploreScreen()
                    Destination.READING -> ReadingScreen()
                    Destination.PROFILE -> ProfileScreen()
                }
            }
        }
    }
}