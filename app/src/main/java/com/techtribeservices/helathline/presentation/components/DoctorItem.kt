package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun DoctorItem(data:Doctor) {
    Column {
        Row {
            // thumbnail image
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data.profileImage)
                    .crossfade(true)
                    .build(),
                contentDescription = "${data.fullName()}",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(75.dp)
                    .aspectRatio(1f)
                    .align(Alignment.CenterVertically)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onPrimaryContainer)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = Constants.PADDING_MEDIUM)
                ) {
                    Text(text = "Dr${data.fullName()}",
                        style = MaterialTheme.typography.titleMedium
                            .copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 14.sp
                            ))

                    Text(text = data.speciality?.title ?: "",
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = MaterialTheme.colorScheme.outline
                        ))
                }

                // rating
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

                    Text(text = "4.5",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W500,
                            fontSize = 15.sp
                        ))
                }
            }
        }
        Spacer(modifier = Modifier
            .height(Constants.PADDING_MEDIUM))
    }

}