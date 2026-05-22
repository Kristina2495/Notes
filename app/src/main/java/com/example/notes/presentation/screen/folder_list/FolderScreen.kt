package com.example.notes.presentation.screen.folder_list

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.example.notes.presentation.screen.folder_list.FolderUiState

@Composable
fun FolderScreen (state: FolderUiState, onEvent: (FolderEvent) -> Unit) {
    Box() {
        when {
            state.isLoading -> {}
            state.folders.isEmpty() -> {}
            else -> {
                FolderList(folders = state.folders, onFolderClick = { folderId ->
                    onEvent(FolderEvent.FolderOnClick(folderId))})
            }
        }
    }
}