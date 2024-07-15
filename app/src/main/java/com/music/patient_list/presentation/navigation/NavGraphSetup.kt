package com.music.patient_list.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.music.patient_list.presentation.PatientDetails.PatientDetails
import com.music.patient_list.presentation.PatientList.PatientList


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphSetUp(navHostController: NavHostController,scrollBehavior: TopAppBarScrollBehavior) {
    NavHost(navController = navHostController, startDestination = Routes.PatientList.route) {
        composable(Routes.PatientList.route) {
            PatientList(
                onItemClicked = { patientId ->
                    navHostController.navigate(Routes.PatientDetails.createRoute(patientId))
                },
                onFABClicked = {
                    navHostController.navigate(Routes.PatientDetails.createRoute(-1))
                },
                scrollBehavior =scrollBehavior
            )
        }

        composable(Routes.PatientDetails.route, arguments = listOf(navArgument("patientId") { type = NavType.IntType })) { backStackEntry ->
            val patientId = backStackEntry.arguments?.getInt("patientId")
            patientId?.let {
                PatientDetails(
                    patientId = it,
                    onBackButtonClicked = { navHostController.navigateUp() },
                    onSaveClicked = { navHostController.navigateUp() }
                )
            }
        }
    }
}