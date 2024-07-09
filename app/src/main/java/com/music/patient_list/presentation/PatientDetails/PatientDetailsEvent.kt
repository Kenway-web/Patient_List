package com.music.patient_list.presentation.PatientDetails

 sealed class PatientDetailsEvent{
     data class NameChanged(val name:String):PatientDetailsEvent()
     data class AgeChanged(val age:String):PatientDetailsEvent()
     data class DoctorNameChanged(val doctorName:String):PatientDetailsEvent()
     data class DoctorPrescriptionChanged(val doctorPrescription:String):PatientDetailsEvent()
     object SaveButtonClicked:PatientDetailsEvent()
     object SelectMale:PatientDetailsEvent()
     object SelectFemale:PatientDetailsEvent()
 }