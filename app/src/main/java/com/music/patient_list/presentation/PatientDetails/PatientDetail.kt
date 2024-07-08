package com.music.patient_list.presentation.PatientDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.music.patient_list.presentation.components.TopAppBarState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientDetails() {

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBarState(
                showBackButton = true,
            )

        }
    }

}