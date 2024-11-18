package com.techtribeservices.helathline.presentation.pages.Onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.techtribeservices.helathline.data.model.Onboarding
import com.techtribeservices.helathline.ui.theme.poppinsFamily
import com.techtribeservices.helathline.utils.Constants
import com.techtribeservices.helathline.utils.ScreenSize

@Composable
fun OnboardingItem(
    onboardingItem: Onboarding,
) {
    val deviceScreen = ScreenSize()
    Column(
        modifier = Modifier
            .padding(Constants.PADDING_LARGE)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(deviceScreen.height/2)
        ) {
            Image(
                painter = painterResource(onboardingItem.image),
                contentDescription = "${onboardingItem.title}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(
            modifier = Modifier
                .height(Constants.PADDING_LARGE)
        )

        Text(
            text = stringResource(onboardingItem.title),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(Constants.PADDING_MEDIUM)
        )

        Text(
            text = stringResource(onboardingItem.subTitle),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}