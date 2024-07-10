package com.music.patient_list.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.music.patient_list.domain.model.PatientDetails


@Composable
fun  PatientLazyColumn(
    modifier: Modifier = Modifier,
    patientList:List<PatientDetails>,
    ItemClicked: () -> Unit
) {
    LazyColumn(
        modifier =modifier
            .padding(10.dp)
            .clickable { ItemClicked() }
    ) {
        items(patientList){ patient->
            PatientCard(
                patient = patient,
                onItemClicked = {},
                onDeleteConfirm = {},
            )
          Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}