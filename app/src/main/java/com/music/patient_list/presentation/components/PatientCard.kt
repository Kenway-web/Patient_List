package com.music.patient_list.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.music.patient_list.presentation.PatientList.DeleteDialog


@Composable
fun PatientCard(
    modifier: Modifier = Modifier,
    patient: PatientDetails,
    onItemClicked: () -> Unit,
    onDeleteConfirm: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        DeleteDialog(title = "Delete",
            message = "Are you sure you want to delete" + "patient \"${patient.name}\" from patient list",
            onDialogDismissClicked = { showDialog = false },
            onConfirmButtonClicked = {
                onDeleteConfirm()
                showDialog = false
            })

    }
    Card(
        modifier = modifier.clickable { onItemClicked() },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .weight(2f)
                    .scale(1.5f),
                painter = painterResource(id = R.drawable.ic_patient),
                contentDescription = "Sick patient"
            )

            Spacer(modifier = Modifier.width(10.dp))

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
                        style = MaterialTheme.typography.bodySmall.copy(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }

            IconButton(onClick = { showDialog = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete item"
                )
            }


        }

    }

}

