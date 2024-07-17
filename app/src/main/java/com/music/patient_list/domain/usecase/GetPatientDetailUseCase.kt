package com.music.patient_list.domain.usecase

import com.music.patient_list.domain.model.PatientDetailsEntity


interface GetPatientDetailUseCase{
     suspend fun getPatientDetailById(id: Int): PatientDetailsEntity?
}