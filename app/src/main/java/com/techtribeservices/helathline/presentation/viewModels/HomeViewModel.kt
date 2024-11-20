package com.techtribeservices.helathline.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techtribeservices.helathline.data.model.Doctor
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.domain.repository.DoctorRepository
import com.techtribeservices.helathline.utils.Constants
import com.techtribeservices.helathline.utils.SeedDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val doctorRepository: DoctorRepository,
    private val seedDB: SeedDB
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<Doctor>>(emptyList())
    val state = _uiState as StateFlow<List<Doctor>>

    init {
        fetchDoctors()
    }

    fun fetchDoctors() {
        viewModelScope.launch {
            try {
                val doctorsList = doctorRepository.getAllDoctors()
                Log.d(Constants.TAG, "Doctors fetched: $doctorsList")
                _uiState.value = doctorsList
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error fetching specialities", e)
            }
        }
    }

    fun seedDB() {
        viewModelScope.launch {
            seedDB.seedDoctors()
        }
    }
}