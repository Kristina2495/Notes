package com.example.notes.presentation.screen.folder_list

sealed interface FolderEvent {
    data object LoadFolders : FolderEvent
    data class FolderOnClick(val folderId : Int) : FolderEvent

    data object OpenCreateNewFolderWindow : FolderEvent
    data object CloseNewFolderWindow : FolderEvent
    data class SaveNewFolder(val folderName : String) : FolderEvent
}