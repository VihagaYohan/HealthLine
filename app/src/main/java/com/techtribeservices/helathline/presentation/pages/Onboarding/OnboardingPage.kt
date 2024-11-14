package com.techtribeservices.helathline.presentation.pages.Onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techtribeservices.helathline.data.model.mockData.onboardingList
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier
) {
    // state
    val pagerState: PagerState = rememberPagerState(
        initialPage =  0,
        pageCount = {3}
    )
    Scaffold(
        bottomBar =  {
            // onboarding action items (Back, pagination indicators and Next / Done)
            OnboardingActions(currentPage = pagerState.currentPage)
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
        OnboardingPage()
    }
}