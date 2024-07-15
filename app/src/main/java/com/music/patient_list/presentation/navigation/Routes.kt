package com.music.patient_list.presentation.navigation

sealed class Routes(val route: String) {
    object PatientList : Routes("patient_list")
    object PatientDetails : Routes("patient_details/{patientId}") {
        fun createRoute(patientId: Int) = "patient_details/$patientId"
    }
}