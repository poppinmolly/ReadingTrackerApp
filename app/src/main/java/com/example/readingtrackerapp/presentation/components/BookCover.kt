package com.example.readingtrackerapp.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun BookCover(url: String) {
    AsyncImage(
        model = url,
        contentDescription = "Book cover",
        modifier = Modifier
            .size(height = 80.dp, width = 60.dp)
            .clip(RoundedCornerShape(15.dp))

    )
}