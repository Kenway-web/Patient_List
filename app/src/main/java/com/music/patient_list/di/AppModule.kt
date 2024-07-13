package com.music.patient_list.di

import android.app.Application
import androidx.room.Room
import com.music.patient_list.data.data_source.PatientDatabase
import com.music.patient_list.data.repo.PatientRepoImpl
import com.music.patient_list.domain.repo.PatientRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  AppModule{

    @Provides
    fun providePatientDatabase(app: Application): PatientDatabase {
        return Room.databaseBuilder(
            app,
            PatientDatabase::class.java,
            "patient_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePatientRepo(
        db: PatientDatabase
    ):PatientRepo{
        return PatientRepoImpl(patientDao = db.patientDao)
    }

}