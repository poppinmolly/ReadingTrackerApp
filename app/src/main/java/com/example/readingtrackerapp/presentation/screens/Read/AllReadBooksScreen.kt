package com.example.readingtrackerapp.presentation.screens.Read

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.presentation.screens.Home.BookCover
import com.example.readingtrackerapp.presentation.screens.Home.calculatePercent
import com.example.readingtrackerapp.presentation.screens.Home.calculateProgress
import com.example.readingtrackerapp.ui.theme.backgroundButton
import com.example.readingtrackerapp.ui.theme.cardGradientGreen
import com.example.readingtrackerapp.ui.theme.fontGrayColor
import com.example.readingtrackerapp.ui.theme.lightGreen
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoExtraBold
import com.example.readingtrackerapp.ui.theme.robotoMedium
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray
import com.example.readingtrackerapp.ui.theme.someLightBlue
import com.example.readingtrackerapp.ui.theme.stroke

@Composable
fun ReadScreen(){
    ReadScreenUi()
}

@Composable
fun ReadScreenUi(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BottomText()
        RankCardElement()
        ReadingBookCard()
    }

}

@Composable
fun BottomText(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Finished books",
            fontSize = 23.sp,
            fontFamily = robotoSemiBold,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "1 book completed",
            fontSize = 17.sp,
            fontFamily = roboto,
            color = slateGray,
        )
    }
}


@Composable
fun RankCardElement(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Spacer(modifier = Modifier.height(18.dp))

        val greenGradient = Brush.horizontalGradient(cardGradientGreen)
        // CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(greenGradient)
        ) {
            // Top-right icon box
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 16.dp)
                    .size(53.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .background(Color.White.copy(0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_trophy),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp),
                    tint = Color.White
                )
            }
            // MAIN CONTENT (3 blocks: top / middle / bottom)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // TOP BLOCK
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            text = "Next Rank",
                            fontSize = 14.sp,
                            fontFamily = roboto,
                            color = fontGrayColor
                        )
                    }

                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "Reader",
                            fontSize = 30.sp,
                            color = Color.White,
                            fontFamily = robotoExtraBold,
                            lineHeight = 60.sp
                        )
                    }
                }
                // MIDDLE BLOCK (Goal + % + progress)
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "2 books to reach Reader!",
                            fontSize = 14.sp,
                            color = fontGrayColor,
                            fontFamily = roboto
                        )
                        Text(
                            text = "45%",
                            fontSize = 14.sp,
                            color = fontGrayColor,
                            fontFamily = roboto
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    // Progress bar
                    Box(
                        modifier = Modifier
                            .height(8.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(40.dp))
                            .background(Color.White.copy(alpha = 0.35f))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.4f)
                                .clip(RoundedCornerShape(40.dp))
                                .background(Color.White)
                        )
                    }
                }
                // BOTTOM BLOCK (divider + bottom row)
                Column {
                    Spacer(modifier = Modifier.height(12.dp))


                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            text = "1 of 3 books completed",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = roboto
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ReadingBookCard(){

    Surface(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(150.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .border(1.dp, stroke, shape = RoundedCornerShape(12.dp))
            .clickable {TODO()},

        ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            BookCover("")
            Spacer(modifier = Modifier.width(15.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(text = "The Midnight Library",
                    fontFamily = robotoMedium,
                    fontSize = 17.sp,

                    )

                Text(text = "Matt Haig",
                    fontFamily = roboto,
                    fontSize = 14.sp,
                    color = slateGray,

                    )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(11.dp))
                            .background(lightGreen.copy(0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_check_mark),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = lightGreen,
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "304 pages",
                        fontFamily = roboto,
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(11.dp))
                            .background(someLightBlue.copy(0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_calendar),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = someLightBlue,
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "17 march 2026",
                        fontFamily = roboto,
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                    )
                }



            }
        }
    }
}