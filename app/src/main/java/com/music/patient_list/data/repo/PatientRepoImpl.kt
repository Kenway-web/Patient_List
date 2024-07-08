package com.music.patient_list.data.repo

import com.music.patient_list.data.data_source.PatientDao
import com.music.patient_list.domain.model.PatientDetails
import com.music.patient_list.domain.repo.PatientRepo
import kotlinx.coroutines.flow.Flow

class PatientRepoImpl(
    private val dao: PatientDao
): PatientRepo {
    override suspend fun insertPatient(patient: PatientDetails) {
        return dao.insertPatient(patient)
    }

    override suspend fun deletePatient(patient: PatientDetails) {
        return dao.deletePatient(patient)
    }

    override fun getPatients(): Flow<List<PatientDetails>> {
        return dao.getPatients()
    }

    override suspend fun getPatientById(id: Int): PatientDetails? {
        return dao.getPatientById(id)
    }
}