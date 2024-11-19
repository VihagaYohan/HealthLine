package com.techtribeservices.helathline.presentation.pages.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.data.model.mockData.specialityList
import com.techtribeservices.helathline.presentation.components.Banner
import com.techtribeservices.helathline.presentation.components.CategoryItem
import com.techtribeservices.helathline.presentation.components.SubTitleContainer
import com.techtribeservices.helathline.presentation.components.UserHeader
import com.techtribeservices.helathline.presentation.viewModels.HomeViewModel
import com.techtribeservices.helathline.utils.Constants

@Composable
fun HomePage(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.state.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            UserHeader()
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    vertical = Constants.PADDING_EXTRA_LARGE,
                    horizontal = Constants.PADDING_MEDIUM
                )
        ) {
            LazyColumn() {
                // banner
                item {
                    Banner()
                }

                // sub-title container
                item {
                    Spacer(modifier = Modifier.height(Constants.PADDING_LARGE))
                    SubTitleContainer(
                        title = stringResource(id = R.string.categories),
                        actionTitle = stringResource(R.string.seeAll)
                    )
                }

                // category list
                item {
                    CategoryList()
                }
            }
        }

    }
}

@Composable
fun CategoryList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_MEDIUM)
    ) {
        items(specialityList) {item ->
            CategoryItem(item)
        }
    }
}
