package com.example.readingtrackerapp.presentation.screens.Explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.ui.theme.backgroundButton
import com.example.readingtrackerapp.ui.theme.colorBackgroundDefault
import com.example.readingtrackerapp.ui.theme.errorRedColor
import com.example.readingtrackerapp.ui.theme.fontGrayColor
import com.example.readingtrackerapp.ui.theme.lightGray
import com.example.readingtrackerapp.ui.theme.lightGreen
import com.example.readingtrackerapp.ui.theme.mintBg
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray

@Composable
fun ExploreScreen(
    vm: ExploreScreenViewModel = hiltViewModel()
){
    ExploreScreenUi(
        textValue = vm.stateText,
        onTextChange = vm::onTextChange,
        onClickButton = vm::searchBook,
        textError = vm.error
    )
}


@Composable
fun ExploreScreenUi(
    textValue: String,
    onTextChange: (String) -> Unit,
    onClickButton: () -> Unit,
    textError: String?,
){
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
                value = textValue,
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(12.dp),
                        ambientColor = Color.Black.copy(alpha = 0.72f),
                        spotColor = Color.Black.copy(alpha = 0.72f)
                    )
                    .clip(shape = RoundedCornerShape(12.dp)),
                onValueChange = onTextChange,
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {

            if (textError == null){
                CenterOfScreenUi(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                ErrorScreen(modifier = Modifier.align(Alignment.Center), textError = textError)
            }


            SearchButton(
                modifier = Modifier.align(Alignment.BottomEnd)
                    .padding(bottom = 15.dp),
                onClickButton
            )
        }
    }
}

@Composable
fun CenterOfScreenUi(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(mintBg.copy(0.95f))
                .size(45.dp),
            contentAlignment = Alignment.Center,

        ){
            Icon(
                painter = painterResource(R.drawable.ic_reading),
                contentDescription = null,
                tint = lightGreen,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Find your next book",
            fontFamily = robotoSemiBold,
            fontSize = 18.sp,
            )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Enter a book title or author name above, then tap\nthe button to start searching",
            fontFamily = roboto,
            fontSize = 14.sp,
            color = slateGray,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun SearchButton(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .clip(RoundedCornerShape(17.dp))
            .background(lightGreen)
            .clickable(onClick = onClickButton),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    textError: String,
){
    Column(modifier = modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(errorRedColor.copy(0.95f))
                .size(45.dp),
            contentAlignment = Alignment.Center,

            ){
            Icon(
                painter = painterResource(R.drawable.ic_errormessage),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Sorry friend, not this time",
            fontFamily = robotoSemiBold,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = textError,
            fontFamily = roboto,
            fontSize = 14.sp,
            color = slateGray,
            textAlign = TextAlign.Center,
        )
    }
}