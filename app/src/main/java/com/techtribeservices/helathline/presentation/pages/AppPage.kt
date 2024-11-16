package com.techtribeservices.helathline.presentation.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.navigation.graph.MainNavGraph

@Composable
fun MainPage(
    rootNavController: NavHostController ,
    homeNavController: NavHostController = rememberNavController()
) {

    MainNavGraph(rootNavController,homeNavController)

//   Scaffold {innerPadding ->
//       val modifier = Modifier.padding(innerPadding)
//       Column(
//           modifier = modifier
//       ) {
//           Text("Main page")
//           Button(onClick = {
//               //navController.navigate(AuthScreen.login.route)
//               navController.popBackStack()
//           }) {
//               Text(text = "Go back to login")
//           }
//       }
//   }
}


