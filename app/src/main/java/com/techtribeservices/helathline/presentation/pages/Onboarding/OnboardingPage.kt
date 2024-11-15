package com.techtribeservices.helathline.presentation.pages.Onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.data.model.mockData.onboardingList
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import kotlinx.coroutines.launch

@Composable
fun OnboardingPage(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // state
    val pagerState: PagerState = rememberPagerState(
        initialPage =  0,
        pageCount = {3}
    )
    val animationScope = rememberCoroutineScope()

    Scaffold(
        bottomBar =  {
            // onboarding action items (Back, pagination indicators and Next / Done)
            OnboardingActions(
                currentPage = pagerState.currentPage,
                navController = navController,
                onBackClick = {
                    animationScope.launch {
                        if(pagerState.currentPage != 0) {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
                onProceedClick = {
                    animationScope.launch {
                        if(pagerState.currentPage != 2) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                })
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
        ) {
            // onboarding content (image, title and subtitle)
            HorizontalPager(state = pagerState) {
                OnboardingItem(onboardingItem = onboardingList[pagerState.currentPage])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPagePreview() {

    HelathLineTheme {
        OnboardingPage(navController = rememberNavController())
    }
}