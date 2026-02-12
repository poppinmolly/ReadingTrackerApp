package com.example.readingtrackerapp.presentation.screens.Reading

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.ui.model.ItemsModel
import com.example.readingtrackerapp.ui.theme.cardGradientBlue
import com.example.readingtrackerapp.ui.theme.cardGradientGreen
import com.example.readingtrackerapp.ui.theme.darkBlue
import com.example.readingtrackerapp.ui.theme.fontGrayColor
import com.example.readingtrackerapp.ui.theme.lightGray
import com.example.readingtrackerapp.ui.theme.lightGreen
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoExtraBold
import com.example.readingtrackerapp.ui.theme.robotoMedium
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray
import com.example.readingtrackerapp.ui.theme.someLightBlue
import com.example.readingtrackerapp.ui.theme.someLightPurple

@Preview
@Composable
fun ReadingScreen(){
    val pagesReadModel = ItemsModel(
        iconId = R.drawable.ic_books,
        backgroundIcoColor = lightGreen,
        icoColor = lightGreen,
        statText = "Pages Read",
        statDescription = "Total this week"
    )

    val dailyAverageModel = ItemsModel(
        iconId = R.drawable.ic_average,
        backgroundIcoColor = someLightBlue,
        icoColor = someLightBlue,
        statText = "Daily Average",
        statDescription = "Pages per day"
    )

    val readingTimeModel = ItemsModel(
        iconId = R.drawable.ic_clock,
        backgroundIcoColor = someLightPurple,
        icoColor = someLightPurple,
        statText = "Reading Time",
        statDescription = "Hours this week"
    )




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
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "This Week",
            fontSize = 23.sp,
            fontFamily = robotoSemiBold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 15.dp)
            )
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(210.dp)
            ){
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .border(1.dp, Color.DarkGray.copy(0.1f), RoundedCornerShape(20.dp))
                    .clip(shape = RoundedCornerShape(20.dp))
            ){
                Column(modifier = Modifier.fillMaxSize()) {
                    StatItem(item = pagesReadModel)
                    HorizontalDividerUi()
                    StatItem(item = dailyAverageModel)
                    HorizontalDividerUi()
                    StatItem(item = readingTimeModel)
                }

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "All Time",
            fontSize = 23.sp,
            fontFamily = robotoSemiBold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TotalStat()
    }
}

@Composable
fun StatItem(item: ItemsModel){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clip(shape = RoundedCornerShape(13.dp))
                .size(40.dp)
                .background(item.backgroundIcoColor.copy(0.35f)),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(item.iconId),
                contentDescription = null,
                tint = item.icoColor,
                modifier = Modifier.size(20.dp)

            )
        }

        Column() {
            Text(
                text = item.statText,
                fontSize = 15.sp,
                fontFamily = robotoSemiBold
            )
            Text(
                text = item.statDescription,
                fontSize = 13.sp,
                color = slateGray
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            Text(
                text = "487",
                fontSize = 17.sp,
                fontFamily = robotoExtraBold,
            )
        }
    }
}

@Composable
fun HorizontalDividerUi(){
    HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.DarkGray.copy(0.1f))
}
@Composable
fun VerticalDividerUi(){
    VerticalDivider(
        modifier = Modifier
            .fillMaxHeight(0.5f),
        color = Color.LightGray.copy(0.2f)
    )
}
@Preview
@Composable
fun TotalStat(){
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth(0.95f)
            .background(darkBlue)
            .height(100.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // FIRST BLOCK
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "3 247",
                    color = Color.White,
                    fontFamily = robotoExtraBold,
                    fontSize = 25.sp,
                    )
                Text(text = "Total Pages",
                    color = fontGrayColor,
                    fontFamily = robotoMedium,
                    fontSize = 12.sp)
            }
            VerticalDividerUi()

            // SECOND BLOCK
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "8",
                    color = Color.White,
                    fontFamily = robotoExtraBold,
                    fontSize = 25.sp,
                )
                Text(text = "Books",
                    color = fontGrayColor,
                    fontFamily = robotoMedium,
                    fontSize = 12.sp)
            }
            VerticalDividerUi()

            // THIRD BLOCK
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "12",
                    color = Color.White,
                    fontFamily = robotoExtraBold,
                    fontSize = 25.sp,
                )
                Text(text = "Best Streak",
                    color = fontGrayColor,
                    fontFamily = robotoMedium,
                    fontSize = 12.sp)
            }
        }

    }
}
