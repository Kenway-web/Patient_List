package com.music.patient_list.domain.usecase

import com.music.patient_list.domain.model.PatientDetailsEntity

interface DeletePatientUseCase{
    fun deletePatient(patient: PatientDetailsEntity)
}