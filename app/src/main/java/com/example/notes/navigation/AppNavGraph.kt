package com.example.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.FOLDERS
    ) {

        composable (Routes.FOLDERS) {
            RouteFolders (onUserClick = {folderId ->
                navController.navigate(Routes.noteList(folderId))
            })
        }

        composable (Routes.NOTE_LIST) {

        }
    }
}

