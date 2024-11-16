package com.techtribeservices.helathline.presentation.pages.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.navigation.graph.AuthScreen
import com.techtribeservices.helathline.navigation.graph.Graph
import com.techtribeservices.helathline.presentation.viewModels.HomeViewModel

@Composable
fun HomePage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.state.collectAsState()

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        Column(
            modifier = modifier
        ) {
            Text(text = "Bottom app bar page")
            Button(onClick = {
                //navController.navigate(AuthScreen.login.route)
                navController.navigate(Graph.AUTHENTICATION) {
                    popUpTo(AuthScreen.login.route){inclusive = true}
                }
            }) {
                Text(text = "Go to login")
            }
        }

//        ListOfSpecialities(
//            modifier = Modifier.padding(innerPadding),
//            data = uiState.value
//        )
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