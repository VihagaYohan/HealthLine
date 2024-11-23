package com.techtribeservices.helathline.presentation.pages.Home

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.data.model.Doctor
import com.techtribeservices.helathline.data.model.mockData.doctorsList
import com.techtribeservices.helathline.data.model.mockData.specialityList
import com.techtribeservices.helathline.navigation.destinations.Destinations
import com.techtribeservices.helathline.navigation.graph.MainGraph
import com.techtribeservices.helathline.presentation.components.Banner
import com.techtribeservices.helathline.presentation.components.CategoryItem
import com.techtribeservices.helathline.presentation.components.DoctorItem
import com.techtribeservices.helathline.presentation.components.SubTitleContainer
import com.techtribeservices.helathline.presentation.components.UserHeader
import com.techtribeservices.helathline.presentation.viewModels.HomeViewModel
import com.techtribeservices.helathline.utils.Constants
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun HomePage(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.state.collectAsState()
    val listState = rememberLazyListState()
    val snapper = rememberSnapperFlingBehavior(listState)

    Scaffold(
        modifier = modifier,
        topBar = {
            UserHeader()
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        val scrollState = rememberScrollState()

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    vertical = Constants.PADDING_EXTRA_LARGE,
                    horizontal = Constants.PADDING_MEDIUM
                )
                .verticalScroll(scrollState)
        ) {
            Banner()

            SubTitleContainer(
                title = stringResource(id = R.string.categories),
                actionTitle = stringResource(id = R.string.seeAll)
            )

            CategoryList()

            SubTitleContainer(
                title = stringResource(id = R.string.upcoming_appointments),
                actionTitle = stringResource(id = R.string.seeAll)
            )

            // upcoming appointments
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                state = listState,
                flingBehavior = snapper,
            ) {
                items(3) {
                    Box(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(Constants.PADDING_MEDIUM),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        ) {
                            UpcomingAppointmentItem()
                        }
                    }
                }
            }

            // popular doctors
            SubTitleContainer(
                title = stringResource(id = R.string.popular),
                actionTitle = stringResource(id = R.string.seeAll)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_MEDIUM)
            ) {
                items(3) {
                    val doctor = doctorsList[0]
                    DoctorItem(data = doctor, onClick = {
                        Log.d(Constants.TAG, "item clicked")
                        //navController.navigate(route = MainGraph.Secondary)
                        navController.navigate(Destinations.DoctorDetails(doctorId = "11789"))
                    })
                }
            }

            Spacer(modifier = Modifier.height(Constants.PADDING_LARGE))
        }
    }
}

// category list component
@Composable
fun CategoryList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_MEDIUM)
    ) {
        items(specialityList) { item ->
            CategoryItem(item)
        }
    }
}


@Composable
fun UpcomingAppointmentItem() {
    Box(
        modifier = Modifier
            .padding(Constants.PADDING_MEDIUM),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_LARGE)
        ) {
            // date and day
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(Constants.PADDING_EXTRA_LARGE))
                    .padding(Constants.PADDING_MEDIUM)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "12",
                        style = MaterialTheme.typography.displayLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )

                    Text(
                        text = "TUE",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
            }

            // doctor details
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Column {
                    Text(
                        text = "Dr. John Doe", style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp
                        )
                    )
                    Text(
                        text = "specialist: Cardiologist",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 13.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(Constants.PADDING_MEDIUM))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_SMALL),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = "hospital location",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(
                            text = "St. Johns Hospital",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 13.sp
                            )

                        )
                    }

                    Spacer(modifier = Modifier
                        .height(Constants.PADDING_MEDIUM/2))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_SMALL),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Filled.AccessTimeFilled,
                            contentDescription = "hospital location",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(
                            text = "10:00 A.M",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 13.sp
                            )

                        )
                    }

                }
            }
        }
    }
}