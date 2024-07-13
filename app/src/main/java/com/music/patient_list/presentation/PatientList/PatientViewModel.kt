package com.music.patient_list.presentation.PatientList

import androidx.lifecycle.ViewModel
import com.music.patient_list.domain.repo.PatientRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PatientListViewModel @Inject constructor(private val patientRepo: PatientRepo) : ViewModel() {

}