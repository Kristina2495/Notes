package com.example.notes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notes.presentation.screen.folder_list.FolderEvent
import com.example.notes.presentation.screen.folder_list.FolderScreen
import com.example.notes.presentation.screen.folder_list.FolderViewModel

@Composable
fun RouteFolders(viewModel: FolderViewModel = viewModel(),
                 onUserClick: (Int) -> Unit) {
    val state by viewModel.uiState.collectAsState()

    FolderScreen(state = state, onEvent = {event ->
        when (event) {
            is FolderEvent.FolderOnClick -> onUserClick(event.folderId)
            is FolderEvent.LoadFolders -> viewModel.onEvent(event)
            is FolderEvent.OpenCreateNewFolderWindow -> viewModel.onEvent(event)
            is FolderEvent.SaveNewFolder -> viewModel.onEvent(event)
            is FolderEvent.CloseNewFolderWindow -> viewModel.onEvent(event)
        }
    })
}