package com.music.patient_list.presentation.PatientList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.usecaseImpl.DeletePatientUseCaseImpl
import com.music.patient_list.domain.usecaseImpl.GetAllPatientsImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PatientListViewModel @Inject constructor(private val deletePatientUseCase: DeletePatientUseCaseImpl,private val getPatientDetailUseCase: GetAllPatientsImpl) : ViewModel() {
    private  val _privateList = MutableStateFlow<List<PatientDetailsEntity>>(emptyList())
    val patientList = _privateList

    init {
        viewModelScope.launch { getPatientDetailUseCase.getPatientsList().collect(
            _privateList::emit
        ) }
    }

    fun deletePatient(patient:PatientDetailsEntity){
        viewModelScope.launch {
            deletePatientUseCase.deletePatient(patient)
        }

    }
}