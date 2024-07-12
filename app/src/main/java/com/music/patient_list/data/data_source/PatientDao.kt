package com.music.patient_list.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.music.patient_list.domain.model.PatientDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatient(patient: Patient)

    @Delete
    suspend fun deletePatient(patient: Patient)

    @Query("SELECT * FROM patients")
    fun getPatients(): Flow<List<Patient>>

    @Query("SELECT * FROM patients WHERE id = :id")
    suspend fun getPatientById(id: Int): Patient?
}