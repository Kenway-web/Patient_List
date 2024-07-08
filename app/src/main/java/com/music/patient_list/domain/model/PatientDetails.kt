package com.music.patient_list.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PatientDetails(
    @PrimaryKey
    val id:Int? = null,
    val name:String,
    val age:String,
    val Date:String,
    val gender:String,
    val symptoms:String,
)

class InvalidPatientException(message: String): Exception(message)