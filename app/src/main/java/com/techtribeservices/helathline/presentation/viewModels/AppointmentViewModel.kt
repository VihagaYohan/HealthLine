package com.techtribeservices.helathline.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techtribeservices.helathline.data.model.Appointment
import com.techtribeservices.helathline.domain.repository.AppointmentRepository
import com.techtribeservices.helathline.utils.Constants
import com.techtribeservices.helathline.utils.SeedDB
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppointmentViewModel @Inject constructor(
    private val appointmentRepository: AppointmentRepository,
    private val seedDB: SeedDB
): ViewModel(){
    private val _uiState = MutableStateFlow<List<Appointment>>(emptyList())
    val state = _uiState as StateFlow<List<Appointment>>

    init {
        fetchAppointments()
    }

    fun fetchAppointments() {
        viewModelScope.launch {
            try {
                val appointmentList = appointmentRepository.getAllAppointments()
                _uiState.value = appointmentList
            }catch(e: Exception) {
                Log.e(Constants.TAG, "Error fetching appointments")
            }
        }
    }
}