package com.music.patient_list.data.repo

import com.music.patient_list.data.data_source.Patient
import com.music.patient_list.data.data_source.PatientDao
import com.music.patient_list.data.mapper.toPatientDetails
import com.music.patient_list.data.mapper.toPatientEntity
import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.repo.PatientRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class PatientRepoImpl @Inject constructor(private val patientDao: PatientDao):PatientRepo{


    override suspend fun addOrUpdatePatient(patient: PatientDetailsEntity) {
        patientDao.addOrUpdatePatient(patient.toPatientEntity())
    }


    override suspend fun deletePatient(patient: PatientDetailsEntity) {
        patientDao.deletePatient(patient.toPatientEntity())
    }

    override fun getPatients(): Flow<List<PatientDetailsEntity>> {
        return patientDao.getPatients().map { patients ->
            patients.map { patient -> patient.toPatientDetails() }
        }
    }

    override suspend fun getPatientById(id: Int): PatientDetailsEntity? {
        return patientDao.getPatientById(id)?.toPatientDetails()
    }

}

