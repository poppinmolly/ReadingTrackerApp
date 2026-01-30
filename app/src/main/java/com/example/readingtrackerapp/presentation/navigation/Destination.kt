package com.example.readingtrackerapp.presentation.navigation

import com.example.readingtrackerapp.R

enum class Destination(val route: String, val label: String, val icon: Int,) {
    HOME("home", "Home", R.drawable.ic_home),
    EXPLORE("explore", "Explore", R.drawable.ic_explore),
    READING("reading", "Reading", R.drawable.ic_reading),
    PROFILE("profile", "Profile", R.drawable.ic_profile),
}