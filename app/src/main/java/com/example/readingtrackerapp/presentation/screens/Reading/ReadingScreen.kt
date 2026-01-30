package com.example.readingtrackerapp.presentation.screens.Reading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.ui.theme.cardGradientBlue
import com.example.readingtrackerapp.ui.theme.cardGradientGreen
import com.example.readingtrackerapp.ui.theme.fontGrayColor
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoExtraBold
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray
@Preview
@Composable
fun ReadingScreen(){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(text = "Your stats",
                fontSize = 25.sp,
                fontFamily = robotoSemiBold,

            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Track your reading journey",
                fontSize = 17.sp,
                fontFamily = roboto,
                color = slateGray,)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val greenGradient = Brush.horizontalGradient(cardGradientGreen)
            val blueGradient = Brush.horizontalGradient(cardGradientBlue)

            // GREEN CARD
            Box(modifier = Modifier
                .weight(1f)
                .height(160.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(greenGradient)){

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 14.dp)
                            .clip(RoundedCornerShape(13.dp)),
                        color = Color.White.copy(alpha = 0.2f)
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp), // внутрішній padding
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier.size(28.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_fire),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                        }
                    }

                    Text(text = "12",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = robotoExtraBold,
                    )
                    Text(text = "Day streak",
                        color = fontGrayColor,
                        fontSize = 15.sp,
                        fontFamily = roboto,
                        modifier = Modifier.offset(x = 5.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.width(20.dp))
            // BLUE CARD
            Box(modifier = Modifier
                .weight(1f)
                .height(160.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(blueGradient)){

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 14.dp)
                            .clip(RoundedCornerShape(13.dp)),
                        color = Color.White.copy(alpha = 0.2f)
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier.size(28.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_books),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                        }
                    }

                    Text(text = "8",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = robotoExtraBold,
                    )
                    Text(text = "Books done",
                        color = fontGrayColor,
                        fontSize = 15.sp,
                        fontFamily = roboto,
                        modifier = Modifier.offset(x = 5.dp)
                    )
                }

            }
        }


    }
}