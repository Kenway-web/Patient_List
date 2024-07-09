package com.music.patient_list.presentation.PatientDetails

data class PatientDetailsUIState(
    val name: String = "",
    val age: String = "",
    val gender: Int = 0,
    val doctorName: String = "",
    val doctorPrescription: String = ""
)

