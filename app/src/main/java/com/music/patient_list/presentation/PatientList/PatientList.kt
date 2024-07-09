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
import com.music.patient_list.R
import com.music.patient_list.domain.model.PatientDetails
import com.music.patient_list.presentation.components.PatientLazyColumn
import com.music.patient_list.presentation.components.TopAppBarState


val patients = listOf(
    PatientDetails(
        id = 1,
        name = "John Doe",
        age = "30",
        Date = "2022-01-01",
        gender = "Male",
        symptoms = "Headache, Fever"
    ),
    PatientDetails(
        id = 2,
        name = "Jane Smith",
        age = "25",
        Date = "2022-01-05",
        gender = "Female",
        symptoms = "Cough, Sore Throat"
    ),
    PatientDetails(
        id = 3,
        name = "Bob Johnson",
        age = "40",
        Date = "2022-01-10",
        gender = "Male",
        symptoms = "Fatigue, Muscle Pain"
    ),
    PatientDetails(
        id = 4,
        name = "Alice Brown",
        age = "28",
        Date = "2022-01-12",
        gender = "Female",
        symptoms = "Nausea, Dizziness"
    ),
    PatientDetails(
        id = 5,
        name = "Mike Davis",
        age = "35",
        Date = "2022-01-15",
        gender = "Male",
        symptoms = "Back Pain, Headache"
    ),
    PatientDetails(
        id = 6,
        name = "Emily Taylor",
        age = "22",
        Date = "2022-01-18",
        gender = "Female",
        symptoms = "Sore Throat, Runny Nose"
    ),
    PatientDetails(
        id = 7,
        name = "Sarah Lee",
        age = "38",
        Date = "2022-01-20",
        gender = "Female",
        symptoms = "Fatigue, Joint Pain"
    ),
    PatientDetails(
        id = 8,
        name = "David Kim",
        age = "42",
        Date = "2022-01-22",
        gender = "Male",
        symptoms = "Chest Pain, Shortness of Breath"
    ),
    PatientDetails(
        id = 9,
        name = "Lisa Nguyen",
        age = "29",
        Date = "2022-01-25",
        gender = "Female",
        symptoms = "Abdominal Pain, Diarrhea"
    ),
    PatientDetails(
        id = 10,
        name = "Kevin White",
        age = "45",
        Date = "2022-01-28",
        gender = "Male",
        symptoms = "Headache, Nausea"
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientList(
    scrollBehavior: TopAppBarScrollBehavior,
) {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBarState(scrollBehavior = scrollBehavior, onBackButtonClicked = {})
            PatientLazyColumn(modifier = Modifier, patients)
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add patient"
            )
        }
    }
}


//@Preview
//@Composable
//fun DefaultPreview() {
//    PatientList(sc)
//}