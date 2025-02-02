package com.music.patient_list.presentation.PatientDetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import com.music.patient_list.data.data_source.Patient
import com.music.patient_list.presentation.components.TopAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import java.time.Instant
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientDetails(
    viewModel:  PatientDetailsViewModel = hiltViewModel(),
    onBackButtonClicked: () -> Unit,
    onSaveClicked:() -> Unit,
    patientId: Int
) {

    LaunchedEffect(key1 = patientId) {
        if(patientId!=-1){
            viewModel.fetchPatient(patientId)
        }
    }

    val state = viewModel.state
    val focusRequester = remember {
        FocusRequester()
    }

    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = Unit) {
        delay(500)
        focusRequester.requestFocus()
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            TopAppBarState(
                showBackButton = true,
                onBackButtonClicked = onBackButtonClicked,
                title = "Patient Detail"
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp) // Padding for the form fields
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    value = state.name,
                    onValueChange = {newvalue->
                        viewModel.onEvent(PatientDetailsEvent.NameChanged(newvalue))
                    },
                    label = {
                        Text(
                            text = "Patient Name",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = state.age,
                        onValueChange = {
                            viewModel.onEvent(PatientDetailsEvent.AgeChanged(it))
                        },
                        label = {
                            Text(
                                text = "Age",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Next)
                            }
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    GenderRadioButton(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        text = "Male",
                        selected = state.gender==1,
                        onClick = {
                            viewModel.onEvent(PatientDetailsEvent.SelectMale)
                        }
                    )

                    GenderRadioButton(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        text = "Female",
                        selected = state.gender==2,
                        onClick = {
                            viewModel.onEvent(PatientDetailsEvent.SelectFemale)
                        }
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.doctorName,
                    onValueChange = {
                        viewModel.onEvent(PatientDetailsEvent.DoctorNameChanged(it))
                    },
                    label = {
                        Text(
                            text = " Assigned Doctor's Name",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    ),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    value = state.doctorPrescription,
                    onValueChange = {
                        viewModel.onEvent(PatientDetailsEvent.DoctorPrescriptionChanged(it))
                    },
                    label = {
                        Text(
                            text = "Doctor's Prescription.",
                        )
                    },
                    textStyle = MaterialTheme.typography.bodyLarge,
                )

                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        viewModel.onEvent(PatientDetailsEvent.SaveButtonClicked)
                        onSaveClicked()
                    }

                ) {
                    Text(
                        text = "Save",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }

            }
        }

    }

}


// state :Anything that can change during the usage of the app.
// event : Anything that a user can do is event