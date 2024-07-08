package com.music.patient_list.domain.use_case

import com.music.patient_list.domain.model.PatientDetails
import com.music.patient_list.domain.repo.PatientRepo
import javax.inject.Inject

class DeletePatient @Inject constructor(
    private val repo: PatientRepo
) {
    suspend operator fun invoke(patient: PatientDetails) {
        repo.deletePatient(patient)
    }
}