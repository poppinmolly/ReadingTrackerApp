package com.example.readingtrackerapp.presentation.screens.Home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.presentation.navigation.AppNavHost
import com.example.readingtrackerapp.presentation.navigation.Destination
import com.example.readingtrackerapp.ui.theme.backgroundButton
import com.example.readingtrackerapp.ui.theme.buttonGradient
import com.example.readingtrackerapp.ui.theme.cardGradientGreen
import com.example.readingtrackerapp.ui.theme.colorBackgroundDefault
import com.example.readingtrackerapp.ui.theme.fontGrayColor
import com.example.readingtrackerapp.ui.theme.lightGray
import com.example.readingtrackerapp.ui.theme.lightGreen
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoMedium
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray
import com.example.readingtrackerapp.ui.theme.stroke



@Composable
fun HomeScreen(){
    val navController = rememberNavController()

    HomeScreenUi(navController)

}



@Composable
fun HomeScreenUi(
    navController: NavHostController,
    ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { TopBarPreview() },
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets)  {
                Destination.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            navController.navigate(route = destination.route){
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId){
                                    saveState = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = destination.icon),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                            )
                        },
                        label = {Text(destination.label,)},
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = lightGreen,
                            selectedTextColor = lightGreen,
                            unselectedIconColor = slateGray,
                            unselectedTextColor = slateGray,
                            indicatorColor = lightGreen.copy(alpha = 0.15f)
                        )
                    )
                }

            }
        }
    ) { padding ->
        AppNavHost(navController = navController, startDestination = Destination.HOME, modifier = Modifier.padding(padding))
    }
}

@Composable
fun HomeTabScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(10.dp))


        Main()
        ReadingText()
        ReadingBookCard()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarPreview(){
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            ){
            // LEFT BLOCK
            Row(modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val brush = Brush.verticalGradient(buttonGradient)
                Box(modifier = Modifier

                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(brush)
                    .size(50.dp),
                    contentAlignment = Alignment.Center,

                    ){

                    Icon(
                        painter = painterResource(R.drawable.ic_bookstopbar),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                // TEXT TOPBAR
                Column() {
                    Text(
                        text = "ReadTrack",
                        fontFamily = roboto,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold

                    )
                    Text(text = "Keep reading daily",
                        fontFamily = roboto,
                        fontSize = 14.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))

            Box(modifier = Modifier
                .size(45.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(13.dp),
                    ambientColor = Color.Black.copy(alpha = 0.72f),
                    spotColor = Color.Black.copy(alpha = 0.72f)
                )
                .clip(shape = RoundedCornerShape(13.dp))
                .background(colorBackgroundDefault),
                contentAlignment = Alignment.Center

            ){
                Icon(
                    painter = painterResource(R.drawable.ic_bell),
                    contentDescription = null,
                    tint = slateGray,
                    modifier = Modifier.size(22.dp)
                )

            }

        }

        Spacer(modifier = Modifier.height(15.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFE5E7EB),
            thickness = 1.dp
        )
    }

}
@Composable
fun Main() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {


        // Header texts
        Text(
            text = "Good afternoon",
            fontSize = 25.sp,
            fontFamily = robotoSemiBold,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Ready to continue reading?",
            fontSize = 17.sp,
            fontFamily = roboto,
            color = slateGray,
        )

        Spacer(modifier = Modifier.height(18.dp))

        val greenGradient = Brush.horizontalGradient(cardGradientGreen)

        // CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(215.dp) // підігнано під твій приклад
                .clip(RoundedCornerShape(20.dp))
                .background(greenGradient)
        ) {
            // Top-right icon box
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 16.dp)
                    .size(60.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .background(backgroundButton),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_openbook),
                    contentDescription = null,
                    modifier = Modifier.size(23.dp),
                    tint = Color.Unspecified
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
                        Icon(
                            painter = painterResource(R.drawable.ic_calendar),
                            contentDescription = null,
                            tint = fontGrayColor,
                            modifier = Modifier.size(17.dp)
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(
                            text = "Today's Progress",
                            fontSize = 14.sp,
                            fontFamily = roboto,
                            color = fontGrayColor
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "47",
                            fontSize = 60.sp,
                            color = Color.White,
                            fontFamily = robotoSemiBold,
                            lineHeight = 60.sp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "pages",
                            fontSize = 19.sp,
                            fontFamily = roboto,
                            color = fontGrayColor,
                            modifier = Modifier.padding(bottom = 10.dp)
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
                            text = "Daily Goal: 50 pages",
                            fontSize = 14.sp,
                            color = fontGrayColor,
                            fontFamily = roboto
                        )
                        Text(
                            text = "94%",
                            fontSize = 14.sp,
                            color = fontGrayColor,
                            fontFamily = roboto
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Progress bar (без зайвих padding всередині)
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
                                .fillMaxWidth(0.94f)
                                .clip(RoundedCornerShape(40.dp))
                                .background(Color.White)
                        )
                    }
                }

                // BOTTOM BLOCK (divider + bottom row)
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.White.copy(alpha = 0.18f))
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_fire),
                            contentDescription = null,
                            modifier = Modifier.size(17.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "12 day streak",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = roboto
                        )

                        Spacer(modifier = Modifier.width(18.dp))

                        Icon(
                            painter = painterResource(R.drawable.ic_ontrack),
                            contentDescription = null,
                            modifier = Modifier.size(17.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "On track",
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
fun ProgressBar(
    progress: Float,
){

    Box(
        modifier = Modifier
            .height(8.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .background(Color.White.copy(alpha = 0.35f))
    ){
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(progress)
            .clip(shape = RoundedCornerShape(40.dp))
            .background(Color.White)
        )
    }
}
@Composable
fun ReadingText(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 15.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,) {
        Text(
            text = "Currently Reading",
            fontSize = 20.sp,
            fontFamily = robotoSemiBold,
        )

        Text(
            text = "3 books",
            fontSize = 14.sp,
            fontFamily = roboto,
            color = lightGreen,
        )
    }
}
@Preview
@Composable
fun ReadingBookCard(){
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(100.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .border(1.dp, stroke, shape = RoundedCornerShape(12.dp)),

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Image(
                painter = painterResource(R.drawable.img_test),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 80.dp, width = 60.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column(
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(text = "Five Survive",
                    fontFamily = robotoMedium,
                    fontSize = 17.sp,

                )

                Text(text = "Holly Jackson",
                    fontFamily = roboto,
                    fontSize = 14.sp,
                    color = slateGray,

                    )
                Row(
                    modifier = Modifier.fillMaxWidth(0.95f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Page 187 of 304",
                        fontFamily = roboto,
                        fontSize = 13.sp,
                        color = slateGray,
                    )

                    Text(text = "62%",
                        fontFamily = roboto,
                        fontSize = 13.sp,
                        color = lightGreen,
                    )
                }

                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .fillMaxWidth(0.95f)
                        .clip(shape = RoundedCornerShape(40.dp))
                        .background(Color.LightGray.copy(alpha = 0.35f))
                ){
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.67f)
                        .clip(shape = RoundedCornerShape(40.dp))
                        .background(lightGreen)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBar(){

}
