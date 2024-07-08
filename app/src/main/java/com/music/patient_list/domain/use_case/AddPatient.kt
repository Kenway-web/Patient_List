package com.music.patient_list.domain.use_case

import com.music.patient_list.domain.model.InvalidPatientException
import com.music.patient_list.domain.model.PatientDetails
import com.music.patient_list.domain.repo.PatientRepo
import javax.inject.Inject
import kotlin.jvm.Throws

class AddPatient @Inject constructor(
    private val repo: PatientRepo
) {
    @Throws(InvalidPatientException::class)
    suspend operator fun invoke(patient: PatientDetails) {

        if (patient.name.isBlank()) {
            throw InvalidPatientException("The name of the patient can't be empty")
        }

        if (patient.age.isBlank()) {
            throw InvalidPatientException("The age of the patient can't be empty")
        }

        if (patient.gender.isBlank()){
            throw InvalidPatientException("The gender of the patient can't be empty")
        }

        if (patient.symptoms.isBlank()){
            throw InvalidPatientException("The symptoms of the patient can't be empty")
        }

        repo.insertPatient(patient)

    }
}