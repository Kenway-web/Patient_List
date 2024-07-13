package com.music.patient_list.presentation.PatientList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import com.music.patient_list.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PatientListViewModel @Inject constructor(private val patientRepo: PatientRepo) : ViewModel() {
    private  val _privateList = MutableStateFlow<List<PatientDetailsEntity>>(emptyList())
    val patientList = _privateList

    init {
        viewModelScope.launch { patientRepo.getPatients().collect(
            _privateList::emit
        ) }
    }

    fun deletePatient(patient:PatientDetailsEntity){
        viewModelScope.launch {
            patientRepo.deletePatient(patient)
        }

    }
}