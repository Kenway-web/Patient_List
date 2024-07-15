package com.music.patient_list.domain.usecaseImpl

import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import com.music.patient_list.domain.usecase.DeletePatientUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class DeletePatientUseCaseImpl @Inject constructor(private val patientRepo: PatientRepo) :
    DeletePatientUseCase {
    override suspend fun deletePatient(patient: PatientDetailsEntity) {

        patientRepo.deletePatient(patient)
    }

}