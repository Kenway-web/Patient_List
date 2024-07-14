package com.music.patient_list.presentation.PatientList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.music.patient_list.R
import com.music.patient_list.domain.model.PatientDetailsEntity
import com.music.patient_list.domain.usecase.DeletePatientUseCase
import com.music.patient_list.presentation.components.PatientLazyColumn
import com.music.patient_list.presentation.components.TopAppBarState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientList(
    scrollBehavior: TopAppBarScrollBehavior,
    onItemClicked:(Int) -> Unit,
    onFABClicked: () -> Unit,
    viewModel: PatientListViewModel = hiltViewModel(),
) {

    val patientList = viewModel.patientList
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBarState(scrollBehavior = scrollBehavior,
                onBackButtonClicked = {}, title = "Patient List"
            )

            PatientLazyColumn(
                modifier = Modifier,
                patientList,
                {onItemClicked(it)},
                )

        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = {onFABClicked()}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add patient"
            )
        }
    }
}




