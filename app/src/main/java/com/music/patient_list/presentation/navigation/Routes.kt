package com.music.patient_list.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class Routes {

    @Serializable

    data object PatientList:Routes()

    @Serializable
    data class PatientDetails(val patientId: Int) : Routes()



}