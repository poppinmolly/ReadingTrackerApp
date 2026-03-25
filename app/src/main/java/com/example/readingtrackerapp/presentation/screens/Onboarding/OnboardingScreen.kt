package com.example.readingtrackerapp.presentation.screens.Onboarding

import android.app.Activity
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.readingtrackerapp.R
import com.example.readingtrackerapp.presentation.screens.Reading.HorizontalDividerUi
import com.example.readingtrackerapp.ui.theme.colorBackgroundDefault
import com.example.readingtrackerapp.ui.theme.fontGrayColor
import com.example.readingtrackerapp.ui.theme.lightGray
import com.example.readingtrackerapp.ui.theme.lightGreen
import com.example.readingtrackerapp.ui.theme.onboardingBackgroundGradient
import com.example.readingtrackerapp.ui.theme.roboto
import com.example.readingtrackerapp.ui.theme.robotoExtraBold
import com.example.readingtrackerapp.ui.theme.robotoMedium
import com.example.readingtrackerapp.ui.theme.robotoSemiBold
import com.example.readingtrackerapp.ui.theme.slateGray
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    vm: OnboardingScreenViewModel = hiltViewModel(),
    onFinish: () -> Unit
){
    val pages = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third,
    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {pages.size})
    HorizontalPager(state = pagerState) { pageIndex ->
        val page = pages[pageIndex]

        OnboardingPageContent(
            page = page,
            onNameChange = vm::onNameChange,
            nameValue = vm.nameValue,
            onPagesChange = vm::onPagesChange,
            pagesValue = vm.pagesValue,
            pagerState = pagerState,
            pagesSelected = vm.pagesSelected,
            onContinueClick = {coroutineScope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage +1)
            }},
            onBackClick = {coroutineScope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage -1)
                                                }},
            onClickGetStarted = vm::onboardingComplete,
            onFinish = onFinish,


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
    pagerState: PagerState,
    pagesSelected: String,
    onContinueClick: () -> Unit,
    onBackClick: () -> Unit,
    onClickGetStarted: () -> Unit,
    onFinish: () -> Unit,

    ){
    val buttonColor = if (nameValue != "") lightGreen else lightGray
    val textColor = if (nameValue != "") Color.White else Color.Gray

    val buttonPagesColor = if (pagesValue != "") lightGreen else lightGray
    val textButtonColor = if (pagesValue != "") Color.White else Color.Gray






    Column(modifier = Modifier
        .fillMaxSize()
        .background(onboardingBackgroundGradient),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.fillMaxHeight(0.15f))

        PageIndicator(pageCount = 3, currentPage = pagerState.currentPage)
        Spacer(modifier = Modifier.height(20.dp))

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

                ButtonOnFirstScreen(
                    textOnButton = "Continue with Google",
                    resIco = R.drawable.ic_google,
                )
                Spacer(modifier = Modifier.height(5.dp))
                OrDivider()
                Spacer(modifier = Modifier.height(5.dp))

                ButtonOnFirstScreen(
                    textOnButton = "Continue with Email",
                    resIco = R.drawable.ic_email,
                )

            }


            OnboardingPage.Second -> {
                TextFieldFirstScreen(
                    textValue = nameValue,
                    onTextChange = onNameChange)
                Spacer(modifier = Modifier.weight(0.9f))
                ButtonContinue(
                    textColor = textColor,
                    buttonColor = buttonColor,
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .height(55.dp)
                        .fillMaxWidth(0.9f),
                    textOnButton = "Continue",
                    onClickButton = {onContinueClick()}
                )
            }
            OnboardingPage.Third -> {
                TextFieldSecondScreen(
                    textValue = pagesValue,
                    onTextChange = onPagesChange
                    )

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.95f),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    CountButton("10", modifier = Modifier.weight(1f),
                        onClickButton = onPagesChange,
                        isSelected = "10" == pagesSelected)
                    CountButton("20", modifier = Modifier.weight(1f),
                        onClickButton = onPagesChange,
                        isSelected = "20" == pagesSelected)
                    CountButton(
                        "50", modifier = Modifier.weight(1f),
                        onClickButton = onPagesChange,
                        isSelected = "50" == pagesSelected
                    )
                }
                Spacer(modifier = Modifier.weight(0.9f))
                ButtonGetBack(
                    textColor = Color.DarkGray,
                    textOnButton = "Back",
                    onBackClick = onBackClick
                )
                ButtonContinue(
                    textColor = textButtonColor,
                    buttonColor = buttonPagesColor,
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .height(55.dp)
                        .fillMaxWidth(0.9f),
                    textOnButton = "Get Started",
                    onClickButton = {
                        onClickGetStarted()
                        onFinish()
                    }
                )

            }
        }



    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        repeat(pageCount){
            IndicatorSingleRow(isSelected = it == currentPage)
        }
    }
}


@Composable
fun IndicatorSingleRow(isSelected: Boolean){
    val width = animateDpAsState(65.dp)
    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(7.dp)
            .width(width.value)
            .clip(shape = RoundedCornerShape(25.dp))
            .background(if (isSelected) lightGreen else slateGray)

    )
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
        maxLines = 1,
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
        maxLines = 1,

        placeholder = {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "20",
                    fontSize = 17.sp,
                    fontFamily = roboto,
                    color = slateGray.copy(0.7f),)

                Text(
                    text = "pages",
                    fontSize = 17.sp,
                    fontFamily = roboto,
                    color = slateGray.copy(0.7f),)

            }
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
fun ButtonContinue(
    textColor: Color,
    buttonColor: Color,
    modifier: Modifier,
    textOnButton: String,
    onClickButton: () -> Unit,
){
    Button(onClick = onClickButton,
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = Color.Unspecified,
        )

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = textOnButton,
                fontFamily = robotoSemiBold,
                fontSize = 16.sp,
                color = textColor,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                painter = painterResource(R.drawable.ic_arrowright),
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
fun ButtonGetBack(
    textColor: Color,
    textOnButton: String,
    onBackClick: () -> Unit
){
    Text(text = textOnButton,
        fontFamily = robotoSemiBold,
        fontSize = 16.sp,
        color = textColor,
        modifier = Modifier.clickable{onBackClick()}
    )
}

@Composable
fun CountButton(
    textOfPages: String,
    modifier: Modifier = Modifier,
    onClickButton: (String) -> Unit,
    isSelected: Boolean,
){
    Button(
        onClick = { onClickButton(textOfPages) },
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .height(55.dp),
        colors = ButtonColors(
            containerColor = if (isSelected) lightGreen.copy(0.2f) else Color.LightGray.copy(0.1f),
            contentColor = if (isSelected) lightGreen else Color.DarkGray,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        ),
        border = BorderStroke(width = if (isSelected) 2.dp else 1.dp, color = if (isSelected) lightGreen else Color.LightGray)

    ) {
        Text(text = textOfPages,
            fontFamily = robotoSemiBold,
            fontSize = 16.sp,
        )
    }
}


@Composable
fun ButtonOnFirstScreen(
    textOnButton: String,
    resIco: Int,
){
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .border(2.dp, Color.Black.copy(0.10f), RoundedCornerShape(17.dp))
            .height(60.dp),
        shape = RoundedCornerShape(17.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Unspecified,
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(resIco),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(17.dp)
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = textOnButton,
                fontFamily = robotoSemiBold,
                fontSize = 17.sp,
                color = Color.Black,
            )
        }
    }
}
@Preview
@Composable
fun OrDivider(){
    Row(
        modifier = Modifier.fillMaxWidth(0.9f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f), color = Color.DarkGray.copy(0.1f))
        Text(
            text = "or",
            fontSize = 15.sp,
            fontFamily = roboto,
            color = slateGray,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        HorizontalDivider(modifier = Modifier.weight(1f), color = Color.DarkGray.copy(0.1f))
    }
}