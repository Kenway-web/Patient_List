package com.music.patient_list.data.mapper

import com.music.patient_list.data.data_source.Patient
import com.music.patient_list.domain.model.PatientDetails


fun PatientDetails.toPatientEntity(): Patient {
    return Patient(
        id=this.id,
        name=this.name,
        age=this.age,
        gender=this.gender,
        doctorAssigned=this.doctorAssigned,
        prescriptionByDoctor=this.doctorPrescription
    )
}

fun Patient.toPatientDetails(): PatientDetails {
    return PatientDetails(
        id = this.id,
        name = this.name,
        age = this.age,
        gender = this.gender,
        doctorAssigned = this.doctorAssigned,
        doctorPrescription = this.prescriptionByDoctor
    )
}

