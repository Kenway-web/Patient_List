package com.music.patient_list

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.music.patient_list.presentation.PatientDetails.PatientDetails
import com.music.patient_list.presentation.PatientDetails.PatientDetailsViewModel
import com.music.patient_list.presentation.PatientList.PatientList
import com.music.patient_list.presentation.navigation.NavGraphSetUp
import com.music.patient_list.presentation.theme.Patient_ListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Patient_ListTheme {
                // A surface container using the 'background' color from the theme

                val scrollBehavior= TopAppBarDefaults.enterAlwaysScrollBehavior()
                val navController= rememberNavController()
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                ) {
                    NavGraphSetUp(navController,scrollBehavior=scrollBehavior )
                }
            }
        }
    }
}

