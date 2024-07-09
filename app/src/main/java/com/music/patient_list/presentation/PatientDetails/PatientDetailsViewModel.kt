package com.music.patient_list.presentation.PatientDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PatientDetailsViewModel:ViewModel() {
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

                        }
                }
        }
}