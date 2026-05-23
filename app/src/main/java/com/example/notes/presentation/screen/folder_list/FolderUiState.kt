package com.example.notes.presentation.screen.folder_list

import com.example.notes.presentation.screen.model.FolderItem

data class FolderUiState (
    val isLoading : Boolean = false,
    val folders: List<FolderItem> = emptyList<FolderItem>(),
    val error: String? = null,
    val openNewFolderWindow : Boolean = false,
    val savingNewFolder: Boolean = false
)