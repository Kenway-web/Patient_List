package com.music.patient_list.domain.usecase

import com.music.patient_list.domain.model.PatientDetailsEntity
import kotlinx.coroutines.flow.Flow


interface GetPatientDetailUseCase{
     fun getPatientsList(): Flow<List<PatientDetailsEntity>>
}