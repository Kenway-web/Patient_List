package com.music.patient_list.domain.use_case

import com.music.patient_list.domain.model.PatientDetails
import com.music.patient_list.domain.repo.PatientRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPatients @Inject constructor(
    private val repo: PatientRepo
) {
    operator fun invoke(): Flow<List<PatientDetails>> {
        return repo.getPatients()
    }
}