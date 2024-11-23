package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.data.model.Doctor
import com.techtribeservices.helathline.utils.Constants

@Composable
fun DoctorItem(
    data: Doctor,
    onClick:() -> Unit = {}
) {
    val surnameInitial = data.surname.firstOrNull()?.uppercaseChar() ?: ""
    Card(
        modifier = Modifier
            .width(150.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        )
    ) {
        Column(
            modifier = Modifier
        ) {
            // profile image
            Box(modifier = Modifier
                .fillMaxWidth()) {
                AppImage(
                    imageUrl = data.profileImage,
                    contentDescription = stringResource(id = R.string.doctor_profile_image),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                // name
                Text(text = "Dr. $surnameInitial. ${data.firstName} ${data.lastName} ",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.W500,
                        fontSize = 13.sp
                    ),
                    softWrap = true)

                // speciality
                Text(text = "${data.speciality?.title}",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.outline
                    ))

                Box(modifier = Modifier
                    .align(Alignment.End)){
                    Row {
                        Image(
                            painter = painterResource(R.drawable.star),
                            contentDescription = stringResource(R.string.rating),
                            modifier = Modifier
                                .padding(end = 10.dp)
                        )

                        Text(text = "4.5",
                            style = MaterialTheme.typography.labelLarge)
                    }
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