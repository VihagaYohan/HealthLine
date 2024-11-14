package com.techtribeservices.helathline.presentation.pages

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.techtribeservices.helathline.data.model.Doctor
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.presentation.viewModels.HomeViewModel

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.state.collectAsState()

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        ListOfSpecialities(
            modifier = Modifier.padding(innerPadding),
            data = uiState.value
        )
    }
}

@Composable
fun ListOfSpecialities(
    modifier: Modifier = Modifier,
    data: List<Speciality>,
) {
    //Text(text = "list of specialities:")

    //val doctor = Doctor("Doe","John", "Smith","Dr")
    //Text(text = doctor.fullName())
    LazyColumn(modifier = modifier) {
        items(data.size) {
            Text(text = data[it].title)
        }
    }
}