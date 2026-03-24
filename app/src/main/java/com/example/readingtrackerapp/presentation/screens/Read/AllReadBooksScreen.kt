package com.example.readingtrackerapp.presentation.screens.Read

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.data.local.entity.FinishedBooks
import com.example.readingtrackerapp.domain.model.UserRankInfo
import com.example.readingtrackerapp.domain.utills.UserRank
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
import com.example.readingtrackerapp.presentation.components.BookCover

@Preview
@Composable
fun ReadScreen(){
    ReadScreenUi()
}

@Composable
fun ReadScreenUi(
    vm: AllReadBooksScreenViewModel = hiltViewModel(),
){
    val finishedBooks by vm.finishedBooks.collectAsStateWithLifecycle()
    val rankInfo by vm.rankInfo.collectAsStateWithLifecycle()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BottomText()
        RankCardElement(currentRank = rankInfo )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        ColumnViewReadBooks(books = finishedBooks)
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
fun RankCardElement(
    currentRank: UserRankInfo?,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(horizontal = 15.dp)
    ) {
        Spacer(modifier = Modifier.height(18.dp))

        val greenGradient = Brush.horizontalGradient(cardGradientGreen)
        // CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(145.dp)
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
                            text = "Current rank",
                            fontSize = 16.sp,
                            fontFamily = robotoMedium,
                            color = fontGrayColor
                        )
                    }
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = currentRank?.rank?.title.toString(),
                            fontSize = 30.sp,
                            color = Color.White,
                            fontFamily = robotoExtraBold,
                            lineHeight = 60.sp
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = currentRank?.progress.toString(),
                            fontSize = 16.sp,
                            color = fontGrayColor,
                            fontFamily = roboto
                        )

                    }
                }

            }
        }
    }
}

@Composable
fun ReadingBookCard(
    book: FinishedBooks
){

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
            BookCover(book.thumbnail)
            Spacer(modifier = Modifier.width(15.dp))

            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = book.titleOfBook,
                    fontFamily = robotoMedium,
                    fontSize = 17.sp,
                    )

                Text(text = book.authorOfBook,
                    fontFamily = roboto,
                    fontSize = 14.sp,
                    color = slateGray,

                    )
                Spacer(modifier = Modifier.height(5.dp))
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
                        text = book.pagesRead.toString() + " pages",
                        fontFamily = roboto,
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))

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

@Composable
fun ColumnViewReadBooks(
    books: List<FinishedBooks>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(0.98f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(
            items = books,
            key = null,
            ){
            book ->
            ReadingBookCard(book)

        }
    }
}

