package com.techtribeservices.helathline.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.utils.SeedDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class SeedViewModel @Inject constructor(
    private val seedDB: SeedDB
): ViewModel() {
    private val _uiState = MutableStateFlow<List<Speciality>>(emptyList())
    val state = _uiState as StateFlow<List<Speciality>>

    init {
        seedDB()
    }

    fun seedDB() {
        viewModelScope.launch {
            seedDB.seedDoctors()
        }
    }
}