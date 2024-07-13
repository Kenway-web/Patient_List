package com.music.patient_list.data.mapper

import com.music.patient_list.data.data_source.Patient
import com.music.patient_list.domain.model.PatientDetailsEntity


fun PatientDetailsEntity.toPatientEntity(): Patient {
    return Patient(
        id = this.id,
        name=this.name,
        age=this.age,
        gender=this.gender,
        doctorAssigned=this.doctorAssigned,
        prescriptionByDoctor=this.doctorPrescription
    )
}

fun Patient.toPatientDetails(): PatientDetailsEntity {
    return PatientDetailsEntity(
        // Default value for null id
        id = this.id ?: -1,
        name = this.name,
        age = this.age,
        gender = this.gender,
        doctorAssigned = this.doctorAssigned,
        doctorPrescription = this.prescriptionByDoctor
    )
}

