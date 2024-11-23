package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.data.model.Doctor
import com.techtribeservices.helathline.utils.Constants

@Composable
fun DoctorItem(data: Doctor) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 1f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(Constants.PADDING_MEDIUM),
                ambientColor = Color.Red,
                spotColor = MaterialTheme.colorScheme.primary
            ),
        shape = RoundedCornerShape(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Constants.PADDING_MEDIUM,
                    vertical = Constants.PADDING_MEDIUM
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                // thumbnail image
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data.profileImage)
                        .crossfade(true)
                        .build(),
                    contentDescription = "${data.fullName()}",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(70.dp)
                        .aspectRatio(1f)
                        .align(Alignment.CenterVertically)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onPrimaryContainer)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardDetails(data)

                    //BookService()
                }
            }
        }
    }

}

// book now button
@Composable
private fun BookService() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(Constants.PADDING_MEDIUM),
        modifier = Modifier
    ) {
        Text(
            text = stringResource(R.string.book),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// card main details
@Composable
private fun CardDetails(data: Doctor) {
    Column(
        modifier = Modifier
            .padding(start = Constants.PADDING_MEDIUM)
    ) {
        // name
        Text(
            text = "Dr${data.fullName()}",
            style = MaterialTheme.typography.titleMedium
                .copy(
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp
                )
        )

        // speciality title
        Text(
            text = data.speciality?.title ?: "",
            style = MaterialTheme.typography.titleSmall.copy(
                color = MaterialTheme.colorScheme.outline
            )
        )

        Rating()
    }
}

// rating
@Composable
private fun Rating() {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = "rating",
            modifier = Modifier
                .size(16.dp)
        )

        Text(
            text = "4.5",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W500,
                fontSize = 15.sp
            )
        )
    }
}