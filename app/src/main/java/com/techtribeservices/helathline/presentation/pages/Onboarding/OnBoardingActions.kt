package com.techtribeservices.helathline.presentation.pages.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.navigation.Screen
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun OnboardingActions(
    currentPage: Int,
    navController: NavController,
    onBackClick:() -> Unit = {},
    onProceedClick:() -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (currentPage == 1 || currentPage == 2) {
                TextButton(onClick = {
                   onBackClick()
                }) {
                    Text(text = "Back")
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center

        ) {
            PageIndicator(currentPage)
        }

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                if(currentPage == 2) {
                    navController.navigate(Screen.LoginScreen.route)
                }else {
                    onProceedClick()
                }
            }) {
                Text(text = if (currentPage == 2) "Done" else "Next")
            }
        }
    }
}

// pagination indicator
@Composable
fun PageIndicator(currentPage: Int) {
    var color: Color;
    var shape: Shape;
    var width: Int;
    var height: Int

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .wrapContentHeight()
    ) {
        repeat(3) { item ->
            when (currentPage == item) {
                true -> {
                    color = MaterialTheme.colorScheme.primary
                    shape = RoundedCornerShape(10.dp)
                    width = 30
                    height = 10
                }

                false -> {
                    color = MaterialTheme.colorScheme.outlineVariant
                    shape = CircleShape
                    width = 10
                    height = 10
                }
            }

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .width(width.dp)
                    .height(height.dp)
                    .clip(shape)
                    .background(color = color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingActionsPreview() {
    HelathLineTheme {
        OnboardingActions(currentPage = 1, navController = rememberNavController())
    }
}