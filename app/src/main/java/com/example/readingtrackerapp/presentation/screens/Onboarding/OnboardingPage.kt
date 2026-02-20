package com.example.readingtrackerapp.presentation.screens.Onboarding

import com.example.readingtrackerapp.R

sealed class OnboardingPage(
    val title: String,
    val description: String,
    val question: String,
    val resIco: Int,
){
    data object First : OnboardingPage(
        title = "Welcome!",
        description = "Let's personalize your reading journey",
        question = "What's your name?",
        resIco = R.drawable.ic_onboardingfirst
    )

    data object Second : OnboardingPage(
        title = "Set your Goal",
        description = "How many pages do you want to read daily?",
        question = "Daily reading goal",
        resIco = R.drawable.ic_onboardingsecond
    )


}