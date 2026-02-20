package com.example.readingtrackerapp.presentation.screens.Onboarding

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

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.ui.theme.colorBackgroundDefault
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoExtraBold
import com.example.readingtrackerapp.ui.theme.robotoMedium
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray

@Composable
fun OnboardingScreen(
    vm: OnboardingScreenViewModel = hiltViewModel()
){
    val pages = listOf(
        OnboardingPage.First,
        OnboardingPage.Second

    )
    val pagerState = rememberPagerState(pageCount = {pages.size})
    HorizontalPager(state = pagerState) { pageIndex ->
        val page = pages[pageIndex]

        OnboardingPageContent(
            page = page,
            onNameChange = vm::onNameChange,
            onPagesChange = vm::onPagesChange,
            nameValue = vm.nameValue,
            pagesValue = vm.pagesValue
        )
    }
}

@Composable
fun OnboardingPageContent(
    page: OnboardingPage,
    onNameChange: (String) -> Unit,
    nameValue: String,
    onPagesChange: (String) -> Unit,
    pagesValue: String,




){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))

        Icon(
            painter = painterResource(page.resIco),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(110.dp)
        )
        Text(text = page.title,
            fontFamily = robotoExtraBold,
            fontSize = 30.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = page.description,
            fontFamily = roboto,
            fontSize = 18.sp,
            color = slateGray
        )
        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.Start){
            Text(text = page.question,
                fontFamily = robotoMedium,
                fontSize = 15.sp,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        when (page){
            OnboardingPage.First -> {
                TextFieldFirstScreen(
                    textValue = nameValue,
                    onTextChange = onNameChange)
            }
            OnboardingPage.Second -> {
                TextFieldSecondScreen(
                    textValue = pagesValue,
                    onTextChange = onPagesChange
                    )
            }
        }

    }
}

@Composable
fun TextFieldFirstScreen(
    textValue: String,
    onTextChange: (String) -> Unit,
){
    OutlinedTextField(
        value = textValue,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .border(1.2.dp, Color.Gray.copy(0.4f), RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(12.dp)),
        onValueChange = onTextChange,
        placeholder = {
            Text(
                text = "Enter your name",
                fontSize = 17.sp,
                fontFamily = roboto,
                color = slateGray.copy(0.7f),)
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

@Composable
fun TextFieldSecondScreen(
    textValue: String,
    onTextChange: (String) -> Unit
){
    OutlinedTextField(
        value = textValue,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .border(1.2.dp, Color.Gray.copy(0.4f), RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(12.dp)),
        onValueChange = onTextChange,

        placeholder = {
            Text(
                text = "20",
                fontSize = 17.sp,
                fontFamily = roboto,
                color = slateGray.copy(0.7f),)
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