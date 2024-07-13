package com.music.patient_list.domain.repo


import com.music.patient_list.domain.model.PatientDetailsEntity
import kotlinx.coroutines.flow.Flow


interface PatientRepo {
    suspend fun addOrUpdatePatient (patient: PatientDetailsEntity)
    suspend fun deletePatient(patient: PatientDetailsEntity)
    fun getPatients(): Flow<List<PatientDetailsEntity>>
    suspend fun getPatientById(id: Int): PatientDetailsEntity?
}