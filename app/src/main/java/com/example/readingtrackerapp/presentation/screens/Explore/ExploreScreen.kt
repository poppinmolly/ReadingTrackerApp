package com.example.readingtrackerapp.presentation.screens.Explore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.ui.theme.colorBackgroundDefault
import com.example.readingtrackerapp.ui.theme.lightGreen
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray
@Preview
@Composable
fun ExploreScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
            Text(text = "Explore",
                fontSize = 25.sp,
                fontFamily = robotoSemiBold,
                textAlign = TextAlign.Start,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Discover your next great read",
                fontSize = 17.sp,
                fontFamily = roboto,
                color = slateGray,
                )
            Spacer(modifier = Modifier.height(10.dp))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            TextField(
                value = "",
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(12.dp),
                        ambientColor = Color.Black.copy(alpha = 0.72f),
                        spotColor = Color.Black.copy(alpha = 0.72f)
                    )
                    .clip(shape = RoundedCornerShape(12.dp)),
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null,
                        tint = slateGray,
                        modifier = Modifier.size(18.dp)

                    )
                },
                placeholder = {
                    Text(
                        text = "Search books, authors...",
                        fontSize = 17.sp,
                        fontFamily = roboto,
                        color = slateGray,)
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedContainerColor = colorBackgroundDefault,
                    unfocusedContainerColor = colorBackgroundDefault,

                )
            )
        }
    }
}