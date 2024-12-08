package com.techtribeservices.helathline.presentation.pages.DoctorDetails.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.presentation.components.AppSpacer
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleTab() {
    Column {
        var selectedItem by rememberSaveable { mutableIntStateOf(0) }
        var selectedTime by rememberSaveable { mutableIntStateOf(0) }
        var isExpanded by rememberSaveable { mutableStateOf(false) }
        var selectedHospital by remember {
            mutableStateOf("")
        }
        var isFocused by remember {mutableStateOf(false)}

        // handle item click
        fun itemOnClick(index: Int) {
            selectedItem = index
        }
        AppSpacer(isVertical = true, size = Constants.PADDING_LARGE)

        // hospital dropdown list
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable)
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                    },
                readOnly = true,
                value = selectedHospital,
                onValueChange = {},
                singleLine = true,
                label = { Text(stringResource(R.string.choose_hospital), modifier = Modifier
                    .background(Color.Transparent), style = if(isFocused) MaterialTheme.typography.bodySmall.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    ) else MaterialTheme.typography.bodyLarge) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface
                ),

            )

            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = {
                isExpanded = false

            }) {
                DropdownMenuItem(
                    text = { Text(text = "Asiri Hospital") },
                    onClick = {
                        selectedHospital = "Asiri Hospital"
                        isExpanded = false
                    }
                )

                DropdownMenuItem(
                    text = { Text(text = "Nawaloka Hospital") },
                    onClick = {
                        selectedHospital = "Nawaloka Hospital"
                        isExpanded = false
                    }
                )
            }
        }

        AppSpacer(isVertical = true, size = Constants.PADDING_LARGE)

        Text(
            text = stringResource(R.string.choose_date),
            style = MaterialTheme.typography.titleMedium,
        )

        // date list
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Constants.PADDING_MEDIUM),
            horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_MEDIUM)
        ) {
            itemsIndexed(Constants.SCHEDULE_DATES) { index, scheduleDay ->
                var backgroundColor: Color = MaterialTheme.colorScheme.background;
                var borderColor: Color = MaterialTheme.colorScheme.outline;
                var textColor: Color = MaterialTheme.colorScheme.onBackground
                var borderWidth: Dp = 1.dp
                var fontWeight: FontWeight = FontWeight.Normal

                if (selectedItem == index) {
                    backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                    borderColor = MaterialTheme.colorScheme.primary
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer
                    borderWidth = 2.dp
                    fontWeight = FontWeight.SemiBold
                }
                Box(
                    modifier = Modifier
                        .width(70.dp)
                        .clip(RoundedCornerShape(Constants.PADDING_MEDIUM))
                        .border(
                            borderWidth,
                            borderColor,
                            RoundedCornerShape(Constants.PADDING_MEDIUM)
                        )
                        .background(
                            backgroundColor
                        )
                        .clickable {
                            itemOnClick(index)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = Constants.PADDING_MEDIUM,
                                vertical = Constants.PADDING_LARGE
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = scheduleDay.day,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = textColor,
                                fontWeight = fontWeight
                            ),
                        )

                        Text(
                            text = scheduleDay.date.toString(),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = textColor,
                                fontWeight = fontWeight
                            )
                        )
                    }
                }
            }
        }

        AppSpacer(isVertical = true, size = Constants.PADDING_LARGE)

        Text(
            text = stringResource(R.string.choose_time),
            style = MaterialTheme.typography.titleMedium,
        )

        // time list
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Constants.PADDING_MEDIUM),
            horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_MEDIUM)
        ) {
            itemsIndexed(Constants.SCHEDULE_TIMES) { index, scheduleTime ->
                var backgroundColor: Color = MaterialTheme.colorScheme.background;
                var borderColor: Color = MaterialTheme.colorScheme.outline;
                var textColor: Color = MaterialTheme.colorScheme.onBackground
                var borderWidth: Dp = 1.dp
                var fontWeight: FontWeight = FontWeight.Normal

                if (selectedTime == index) {
                    backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                    borderColor = MaterialTheme.colorScheme.primary
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer
                    borderWidth = 2.dp
                    fontWeight = FontWeight.SemiBold
                }
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(Constants.PADDING_MEDIUM))
                    .background(backgroundColor)
                    .border(
                        borderWidth,
                        borderColor,
                        shape = RoundedCornerShape(Constants.PADDING_MEDIUM)
                    )
                    .clickable {
                        selectedTime = index
                    }) {
                    Text(
                        text = scheduleTime,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = textColor,
                            fontWeight = fontWeight
                        ),
                        modifier = Modifier
                            .padding(
                                horizontal = Constants.PADDING_MEDIUM,
                                vertical = Constants.PADDING_MEDIUM
                            )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScheduledTabPreview() {
    HelathLineTheme {
        ScheduleTab()
    }
}
