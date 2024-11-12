package com.techtribeservices.helathline.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period

@RequiresApi(Build.VERSION_CODES.O)
data class ScheduleTemplate(
    val doctorId: String,
    val startDate: LocalDate = LocalDate.now(),
    val startTime: LocalTime,
    val endTime: LocalTime
) {
    private val endDate: LocalDate

    init {
        // set end date for schedule
        val period = Period.of(0,0,7)
        this.endDate = this.startDate.plus(period)
    }
}