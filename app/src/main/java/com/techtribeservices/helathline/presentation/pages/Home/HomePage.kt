package com.techtribeservices.helathline.presentation.pages.Home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.presentation.components.UserHeader
import com.techtribeservices.helathline.presentation.viewModels.HomeViewModel

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
        ) {
            Text(text = "Home page")

        }

    }
}

@Composable
fun ListOfSpecialities(
    modifier: Modifier = Modifier,
    data: List<Speciality>,
) {
    LazyColumn(modifier = modifier) {
        items(data.size) {
            Text(text = data[it].title)
        }
    }
}