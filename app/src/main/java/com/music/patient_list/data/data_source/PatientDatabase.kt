package com.music.patient_list.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.music.patient_list.domain.model.PatientDetails

@Database(entities = [PatientDetails::class], version = 1)
abstract class PatientDatabase: RoomDatabase() {
    abstract val patientDao: PatientDao
}