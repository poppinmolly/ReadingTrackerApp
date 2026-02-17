package com.example.readingtrackerapp.ui.model

import android.accessibilityservice.GestureDescription
import androidx.compose.ui.graphics.Color

data class ItemsModel(
    val iconId: Int,
    val backgroundIcoColor: Color,
    val icoColor: Color,
    val statText: String,
    val statDescription: String,
    val value: String
)
