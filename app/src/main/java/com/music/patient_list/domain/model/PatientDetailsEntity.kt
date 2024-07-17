package com.music.patient_list.domain.model


data class PatientDetailsEntity(
    val id: Int? = null,
    val name: String,
    val age: Int,
    val gender: String,
    val doctorAssigned: String,
    val doctorPrescription: String
)

