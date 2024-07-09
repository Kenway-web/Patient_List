package com.music.patient_list.presentation.PatientList



import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteDialog(
    title: String,
    message: String,
    onDialogDismissClicked:()-> Unit,
    onConfirmButtonClicked:()-> Unit
) {
    AlertDialog(
        title = { Text(text = title, style = MaterialTheme.typography.bodyLarge) },
        text = { Text(text = message, style = MaterialTheme.typography.bodySmall) },
        confirmButton = {
            Button(onClick = onConfirmButtonClicked) {
                Text("Yes")
            }
        },

        dismissButton = {
            Button(onClick = onDialogDismissClicked) {
                Text("No")
            }
        },
        onDismissRequest = {onDialogDismissClicked}
    )

}