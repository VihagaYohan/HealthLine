package com.techtribeservices.helathline.presentation.components

import android.app.Notification.Action
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.techtribeservices.helathline.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserHeader(
    onProfileIconClick: () -> Unit = {},
    onNotificationIconClick: () -> Unit = {}
) {

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    onProfileIconClick()
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "user profile icon")
            }
        },
        title = {
            Title()
        },
        actions = {
            ActionButtons()
        }
    )
}

@Composable
fun Title() {
    Column {
        Text(
            text = stringResource(R.string.hi),
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
        Text(
            text = stringResource(R.string.name),
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun ActionButtons() {
    Row {
       Box(
           modifier = Modifier
       ) {
           IconButton(
               onClick = {}
           ) {
               Icon(
                   imageVector = Icons.Outlined.Notifications,
                   contentDescription = "notification_icon"
               )
           }
       }
    }
}