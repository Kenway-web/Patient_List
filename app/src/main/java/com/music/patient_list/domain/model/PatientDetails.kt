package com.music.patient_list.domain.model



data class PatientDetails(
    val id:Int,
    val name:String,
    val age:Int,
    val gender:String,
    val doctorAssigned: String,
    val doctorPrescription: String
)

