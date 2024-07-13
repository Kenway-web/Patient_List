package com.music.patient_list.presentation.navigation

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.music.patient_list.presentation.PatientDetails.PatientDetails
import com.music.patient_list.presentation.PatientDetails.PatientDetailsViewModel
import com.music.patient_list.presentation.PatientList.PatientList


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphSetup(
    navHostController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior
){
    NavHost(
        navController = navHostController,
        startDestination = Routes.PatientList
    )
    {
        composable<Routes.PatientList> {
            PatientList(
                scrollBehavior = scrollBehavior,
                onItemClicked = {
                    Log.d("TAG1", "${it}")
                    navHostController.navigate(Routes.PatientDetails(it))
                },
                onFABClicked = {
                    navHostController.navigate(Routes.PatientDetails(-1))}
            )
        }

        composable<Routes.PatientDetails> {  backStackEntry->

            PatientDetails(onBackButtonClicked = {navHostController.navigateUp()} )
        }

    }
}