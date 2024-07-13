package com.music.patient_list.presentation.PatientDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientDetailsViewModel  @Inject constructor(private val repository: PatientRepo):ViewModel()  {
        var state by mutableStateOf(PatientDetailsUIState())

        fun onEvent(event:PatientDetailsEvent){
                when(event){

                        is PatientDetailsEvent.NameChanged -> {
                                state=state.copy(name = event.name)
                        }
                        is PatientDetailsEvent.DoctorNameChanged -> {
                                state=state.copy(doctorName = event.doctorName)
                        }
                        is PatientDetailsEvent.AgeChanged -> {
                                state = state.copy(age = event.age)
                        }
                        is PatientDetailsEvent.DoctorPrescriptionChanged -> {
                                state=state.copy(doctorPrescription = event.doctorPrescription)
                        }
                        PatientDetailsEvent.SelectFemale -> {
                                state=state.copy(gender = 2)
                        }
                        PatientDetailsEvent.SelectMale -> {
                                state=state.copy(gender = 1)
                        }
                        PatientDetailsEvent.SaveButtonClicked ->{
                                savePatient()
                        }
                }
        }

        private fun savePatient() {
                viewModelScope.launch {
                        repository.addOrUpdatePatient(
                                PatientDetailsEntity(
                                 name = state.name,
                                 age = state.age.toInt(),
                                 gender = state.gender.toString(),
                                 doctorAssigned = state.doctorName,
                                 doctorPrescription = state.doctorPrescription
                             )
                        )
                }
        }

}