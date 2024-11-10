package com.techtribeservices.helathline.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.domain.repository.DoctorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val doctorRepository: DoctorRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<Speciality>>(emptyList())
    val state = _uiState as StateFlow<List<Speciality>>

    init {
        fetchSpecialities()
    }

    fun fetchSpecialities() {
        viewModelScope.launch {
            try {
                val specialityList = doctorRepository.getAllSpecialities()
                _uiState.value = specialityList
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error fetching specialities", e)
            }
        }
    }
}