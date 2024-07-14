package com.music.patient_list.domain.usecaseImpl

import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import com.music.patient_list.domain.usecase.GetPatientDetailUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPatientsImpl @Inject constructor(private val patientRepo: PatientRepo):GetPatientDetailUseCase {
    override fun getPatientsList(): Flow<List<PatientDetailsEntity>> {
        return patientRepo.getPatients()
    }
}