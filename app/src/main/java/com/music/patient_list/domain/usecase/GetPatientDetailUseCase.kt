package com.music.patient_list.domain.usecase

import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.presentation.PatientDetails.PatientDetailsEvent
import com.music.patient_list.presentation.navigation.Routes
import kotlinx.coroutines.flow.Flow


interface GetPatientDetailUseCase{
     suspend fun getPatientDetailList(): PatientDetailsEvent
}