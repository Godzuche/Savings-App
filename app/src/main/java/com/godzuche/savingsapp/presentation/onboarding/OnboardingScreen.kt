package com.godzuche.savingsapp.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.savingsapp.R
import com.godzuche.savingsapp.presentation.ui.theme.BlackVariant
import com.godzuche.savingsapp.presentation.ui.theme.LightOrange
import com.godzuche.savingsapp.presentation.ui.theme.Poppins
import com.godzuche.savingsapp.presentation.ui.theme.SavingsAppTheme

@Composable
fun OnboardingRoute() {
    SavingsAppTheme {
        OnboardingScreen()
    }
}

@Composable
fun OnboardingScreen() {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        val (onboardingImage, onboardingText, btContinue) = createRefs()

        Image(painter = painterResource(
            id = R.drawable.savings_onboarding_img_svg),
            contentDescription = "Onboarding image",
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(onboardingImage) {
                    linkTo(top = parent.top, bottom = parent.bottom)
                    linkTo(start = parent.start, end = parent.end)
                }
        )
        Text(
            fontSize = 20.sp,
            fontFamily = Poppins,
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = LightOrange)) {
                    append("Save ")
                }
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append("while doing ")
                }
                append("\n")
                withStyle(SpanStyle(color = LightOrange)) {
                    append("transactions")
                }
            },
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(onboardingText) {
                    top.linkTo(onboardingImage.bottom)
                    linkTo(start = parent.start, end = parent.end)
                }
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .constrainAs(btContinue) {
                    linkTo(start = parent.start,
                        end = parent.end,
                        startMargin = 16.dp,
                        endMargin = 16.dp)
                    linkTo(top = parent.top, bottom = parent.bottom, bottomMargin = 8.dp, bias = 1f)
                }
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "Continue")
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = null
                )
            }
        }
    }
}
