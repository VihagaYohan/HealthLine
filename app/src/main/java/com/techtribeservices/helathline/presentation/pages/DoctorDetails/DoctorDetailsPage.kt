package com.techtribeservices.helathline.presentation.pages.DoctorDetails

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.presentation.components.AppButton
import com.techtribeservices.helathline.presentation.components.AppImage
import com.techtribeservices.helathline.presentation.components.AppNavigationBar
import com.techtribeservices.helathline.presentation.components.AppSpacer
import com.techtribeservices.helathline.presentation.components.AppStats
import com.techtribeservices.helathline.presentation.pages.DoctorDetails.tabs.AboutTab
import com.techtribeservices.helathline.presentation.pages.DoctorDetails.tabs.ReviewTab
import com.techtribeservices.helathline.presentation.pages.DoctorDetails.tabs.ScheduleTab
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.utils.Constants
import com.techtribeservices.helathline.utils.ScreenSize
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorDetailsPage(
    doctorId: String,
    navController: NavController
) {
    var tabState = remember{ mutableStateOf(0)}

    Scaffold(
        topBar = {
            AppNavigationBar(
                title = stringResource(R.string.doctor_details)
            )
        },
        bottomBar = {
           if(tabState.value == 0) Row(modifier = Modifier
                .padding(Constants.PADDING_MEDIUM)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                AppButton(
                    title = stringResource(R.string.book_appointment),
                    onClick = {},
                    isPrimary = true
                )
            } else null
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(vertical = innerPadding.calculateTopPadding(), horizontal = Constants.PADDING_MEDIUM)
        Column(modifier = modifier
            .verticalScroll(rememberScrollState())) {
            ProfileImage()

            AppSpacer(isVertical = true, size = Constants.PADDING_MEDIUM)

            // stats section
            AppStats()

            // tabs
            TabRow(
                selectedTabIndex = tabState.value,
                modifier = Modifier
                    .padding(vertical = Constants.PADDING_MEDIUM)
            ) {
                Constants.DOCTOR_DETAILS_TABS.forEachIndexed{index, item ->
                    Tab(
                        selected = tabState.value == index,
                        onClick = {
                            tabState.value = index
                        },
                        text = {
                            Text(text = item)
                        }
                    )
                }
            }
            when(tabState.value) {
                0 -> ScheduleTab()
                1 -> AboutTab()
                2 -> ReviewTab()
            }
        }
    }
}


@Composable
fun ProfileImage() {
    Box() {
        BackgroundShape()
        AppImage(
            imageUrl = "https://fzzypoxsybnlbgvtudxm.supabase.co/storage/v1/object/public/healthline/doctors/8.png",
            contentDescription = stringResource(R.string.doctor_profile_image),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth()
                .height(205.dp)
        )
    }
}

@Composable
fun BackgroundShape() {
    val(width, height) = ScreenSize()

    Canvas(
        modifier = Modifier
            .width(width)
            .height(height/2)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val path = Path().apply {
            moveTo(canvasWidth/4, 30f)
            lineTo(0f, canvasHeight/2f)
            lineTo(0f, canvasHeight)
            lineTo(canvasWidth, canvasHeight)
            lineTo(canvasWidth, canvasHeight/2f)
            close()
        }
        clipPath(
            path = path
        ) {
            drawRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF485D92),
                        Color(0xFF001946),
                        Color(0xFF001C37)
                    )
                ),
                size = size
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorDetailsPreview() {
    HelathLineTheme {
        DoctorDetailsPage(doctorId = "1", navController = rememberNavController())
    }
}