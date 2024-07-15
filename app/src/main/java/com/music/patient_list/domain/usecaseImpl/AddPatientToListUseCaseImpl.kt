package com.music.patient_list.domain.usecaseImpl

import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import com.music.patient_list.domain.usecase.AddPatientListUseCase
import javax.inject.Inject

class AddPatientToListUseCaseImpl @Inject constructor(private val patientRepo: PatientRepo) : AddPatientListUseCase {
    override suspend fun addPatient(patient: PatientDetailsEntity) {
        patientRepo.addOrUpdatePatient(patient)
    }
}