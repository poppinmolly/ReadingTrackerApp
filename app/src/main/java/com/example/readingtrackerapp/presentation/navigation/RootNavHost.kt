package com.example.readingtrackerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.readingtrackerapp.presentation.screens.Home.HomeScreen
import com.example.readingtrackerapp.presentation.screens.Home.HomeScreenUi
import com.example.readingtrackerapp.presentation.screens.Read.ReadScreen

@Composable
fun RootNavHost(){
    val rootNavHost = rememberNavController()

    NavHost(
        rootNavHost,
        "main"
    ){
        composable("main"){
            HomeScreen(onOpenReadBooks = {rootNavHost.navigate("detail")})
        }
        composable("detail"){
            ReadScreen()
        }
    }
}