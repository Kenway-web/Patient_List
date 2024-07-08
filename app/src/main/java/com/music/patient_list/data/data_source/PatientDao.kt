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
    suspend fun insertPatient(patient: PatientDetails)

    @Delete
    suspend fun deletePatient(patient: PatientDetails)

    @Query("SELECT * FROM PatientDetails ORDER BY Date DESC")
    fun getPatients(): Flow<List<PatientDetails>>

    @Query("SELECT * FROM PatientDetails WHERE id = :id")
    suspend fun getPatientById(id: Int): PatientDetails?
}