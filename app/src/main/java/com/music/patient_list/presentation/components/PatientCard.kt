package com.music.patient_list.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.music.patient_list.R
import com.music.patient_list.domain.model.PatientDetails


@Composable
fun PatientCard(
    modifier: Modifier = Modifier,
    patient:PatientDetails,
    onItemClicked:() -> Unit,
){
    Card(
        onClick = {  onItemClicked() },
        shape = RoundedCornerShape(10.dp),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.weight(2f)
                    .scale(1.5f) ,
                painter = painterResource(id =R.drawable.ic_patient),
                contentDescription = "Sick patient"
            )

            Spacer(modifier =modifier.padding(10.dp) )

            Column(modifier = Modifier.weight(6f)) {
                Row {
                    Text(
                        text = patient.name,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row {
                    Text(
                        text = "Age: ${patient.age}",
                        style = MaterialTheme.typography.bodySmall.copy() ,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row {
                    Text(
                        text = "Date: ${patient.Date}",
                        style = MaterialTheme.typography.bodySmall.copy() ,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Image(
                modifier = Modifier.weight(1f)
                    .scale(1.5f) ,
                painter = painterResource(id =R.drawable.ic_delete),
                contentDescription = "Sick patient"
            )


        }
        
    }

}


@Preview
@Composable
fun DefaultPreview() {
    val samplePatient = PatientDetails(
        id = 1,
        name = "John Doe",
        age = "30",
        Date = "2022-01-01",
        gender = "Male",
        symptoms = "Headache, Fever"
    )

    PatientCard(patient = samplePatient, onItemClicked = {})
}