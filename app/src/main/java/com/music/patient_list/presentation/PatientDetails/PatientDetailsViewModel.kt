package com.music.patient_list.presentation.PatientDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import com.music.patient_list.domain.usecaseImpl.AddPatientToListUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientDetailsViewModel @Inject constructor(
    private val addPatientToListUseCase: AddPatientToListUseCaseImpl,
    private val patientRepo: PatientRepo,
) : ViewModel() {

    var currentPatientId:Int?=null

    var state by mutableStateOf(PatientDetailsUIState())


    fun onEvent(event: PatientDetailsEvent) {
        when (event) {

            is PatientDetailsEvent.NameChanged -> {
                state = state.copy(name = event.name)
            }

            is PatientDetailsEvent.DoctorNameChanged -> {
                state = state.copy(doctorName = event.doctorName)
            }

            is PatientDetailsEvent.AgeChanged -> {
                state = state.copy(age = event.age)
            }

            is PatientDetailsEvent.DoctorPrescriptionChanged -> {
                state = state.copy(doctorPrescription = event.doctorPrescription)
            }

            PatientDetailsEvent.SelectFemale -> {
                state = state.copy(gender = 2)
            }

            PatientDetailsEvent.SelectMale -> {
                state = state.copy(gender = 1)
            }

            PatientDetailsEvent.SaveButtonClicked -> {
                savePatient()
            }
        }
    }

    private fun savePatient() {
        viewModelScope.launch {
            addPatientToListUseCase.addPatient(
                PatientDetailsEntity(
                    name = state.name,
                    age = state.age.toInt(),
                    gender = state.gender.toString(),
                    doctorAssigned = state.doctorName,
                    doctorPrescription = state.doctorPrescription,
                    id = currentPatientId
                )
            )
        }
    }

     fun fetchPatient(patientId: Int) {

        if(patientId!=-1) {
             viewModelScope.launch {
                 patientRepo.getPatientById(patientId)?.apply {
                     state = state.copy(
                         name = name,
                         age = age.toString(),
                         gender = gender.toInt(),
                         doctorName = doctorAssigned,
                         doctorPrescription = doctorPrescription,
                     )
                     currentPatientId=patientId
                 }
             }
        }
    }
}