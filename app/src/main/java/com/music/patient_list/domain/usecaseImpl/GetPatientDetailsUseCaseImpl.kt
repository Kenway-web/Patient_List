package com.music.patient_list.domain.usecaseImpl

import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import com.music.patient_list.domain.usecase.GetPatientDetailUseCase
import com.music.patient_list.presentation.PatientDetails.PatientDetailsEvent
import javax.inject.Inject

class GetPatientDetailsUseCaseImpl @Inject constructor(
    private val patientRepo: PatientRepo
) : GetPatientDetailUseCase {

    override suspend fun getPatientDetailById(id: Int): PatientDetailsEntity? {
        return patientRepo.getPatientById(id)
    }
}