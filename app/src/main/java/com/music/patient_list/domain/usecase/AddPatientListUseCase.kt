package com.music.patient_list.domain.usecase

import com.music.patient_list.domain.model.PatientDetailsEntity

interface  AddPatientListUseCase{
    suspend fun addPatient(patient:PatientDetailsEntity)
}