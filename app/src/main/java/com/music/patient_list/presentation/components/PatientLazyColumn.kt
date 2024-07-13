package com.music.patient_list.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.presentation.PatientList.PatientListViewModel
import kotlinx.coroutines.flow.Flow


@Composable
fun  PatientLazyColumn(
    modifier: Modifier = Modifier,
    patientList: Flow<List<PatientDetailsEntity>>,
    ItemClicked: (Int) -> Unit,
    viewModel: PatientListViewModel
) {

    val patientListState by patientList.collectAsState(initial = emptyList())
    LazyColumn(
        modifier =modifier
            .padding(10.dp)
    ) {

        items(patientListState){ patient->
            PatientCard(
                patient = patient,
                onItemClicked = { patient.id?.let { ItemClicked(it) } },
                onDeleteConfirm = {viewModel.deletePatient(patient)},
            )
          Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}