package com.music.patient_list.data.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val age:Int,
    val gender:String,
    val doctorAssigned: String,
    val prescriptionByDoctor: String
)