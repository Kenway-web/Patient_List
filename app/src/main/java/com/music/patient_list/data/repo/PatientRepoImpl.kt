package com.music.patient_list.data.repo

import com.music.patient_list.data.data_source.PatientDao
import com.music.patient_list.data.mapper.toPatientDetails
import com.music.patient_list.data.mapper.toPatientEntity
import com.music.patient_list.domain.model.PatientDetails
import com.music.patient_list.domain.repo.PatientRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class PatientRepoImpl(private val patientDao: PatientDao):PatientRepo{
    override suspend fun insertPatient(patientDetails: PatientDetails) {
        patientDao.insertPatient(patientDetails.toPatientEntity())
    }

    override suspend fun deletePatient(patient: PatientDetails) {
        patientDao.deletePatient(patient.toPatientEntity())
    }

    override fun getPatients(): Flow<List<PatientDetails>> {
        return patientDao.getPatients().map { patients ->
            patients.map { patient -> patient.toPatientDetails() }
        }
    }

    override suspend fun getPatientById(id: Int): PatientDetails? {
        return patientDao.getPatientById(id)?.toPatientDetails()
    }

}

