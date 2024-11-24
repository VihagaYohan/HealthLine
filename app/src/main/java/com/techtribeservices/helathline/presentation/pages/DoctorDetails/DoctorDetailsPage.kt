package com.techtribeservices.helathline.presentation.pages.DoctorDetails

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.presentation.components.AppButton
import com.techtribeservices.helathline.presentation.components.AppNavigationBar
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.utils.Constants
import com.techtribeservices.helathline.utils.ScreenSize

@Composable
fun DoctorDetailsPage(
    doctorId: String,
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppNavigationBar(
                title = stringResource(R.string.doctor_details)
            )
        },
        bottomBar = {
            Row(modifier = Modifier
                .padding(Constants.PADDING_MEDIUM)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                AppButton(
                    title = stringResource(R.string.book_appointment),
                    onClick = {},
                    isPrimary = true
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            BackgroundShape()
        }
    }
}

@Composable
fun BackgroundShape() {
    val(width, height) = ScreenSize()

    Canvas(
        modifier = Modifier
            .width(width)
            .height(height/2)
            .border(2.dp, Color.Green)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val path = Path()

        path.moveTo(canvasWidth/4, 20f)
        path.lineTo(0f, canvasHeight/2f)
        path.lineTo(0f, canvasHeight)
        path.lineTo(canvasWidth, canvasHeight)
        path.lineTo(canvasWidth, canvasHeight/2f)
        path.close()


/*        path.moveTo(canvasWidth/4, 0f)
        path.lineTo(0f, canvasHeight/2f)
        path.lineTo(0f, canvasHeight)
        path.lineTo(canvasWidth, canvasHeight)
        path.lineTo(canvasWidth, canvasHeight/2f)
        path.close()*/

        drawPath(path, color = Color.Red,
            style = Stroke(
                width = 10.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            ))
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorDetailsPreview() {
    HelathLineTheme {
        DoctorDetailsPage(doctorId = "1", navController = rememberNavController())
    }
}