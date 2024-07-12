package com.music.patient_list.domain.repo

import com.music.patient_list.data.data_source.Patient
import com.music.patient_list.domain.model.PatientDetails
import kotlinx.coroutines.flow.Flow


interface PatientRepo {
    suspend fun insertPatient(patient: PatientDetails)
    suspend fun deletePatient(patient: PatientDetails)
    fun getPatients(): Flow<List<PatientDetails>>
    suspend fun getPatientById(id: Int): PatientDetails?
}