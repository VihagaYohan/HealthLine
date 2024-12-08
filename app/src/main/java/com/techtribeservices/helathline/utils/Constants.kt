package com.techtribeservices.helathline.utils

import androidx.compose.ui.unit.dp
import com.techtribeservices.helathline.data.model.ScheduleDay

object Constants {
    val TAG: String = "HealthLine"

    val PADDING_SMALL = 5.dp
    val PADDING_MEDIUM = 10.dp
    val PADDING_LARGE = 20.dp
    val PADDING_EXTRA_LARGE = 30.dp

    val DOCTOR_DETAILS_TABS = listOf("Schedule","About", "Review")

    val SCHEDULE_DATES = listOf(ScheduleDay("Mon", 6), ScheduleDay("Tue", 7), ScheduleDay("Wed", 8), ScheduleDay("Thu", 9), ScheduleDay("Fri", 10), ScheduleDay("Sat", 11), ScheduleDay("Sun", 12))

    val SCHEDULE_TIMES = listOf("9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM")
}