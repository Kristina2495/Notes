package com.example.notes.presentation.screen.folder_list

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FolderScreen (state: FolderUiState, onEvent: (FolderEvent) -> Unit) {
    Box() {
        when {
            state.isLoading -> {CircularProgressIndicator()}
            state.savingNewFolder -> {CircularProgressIndicator()}
            state.folders.isEmpty() -> {
                Text("You have no folders")
                Button(onClick = {onEvent(FolderEvent.OpenCreateNewFolderWindow)})
                {Text("Add a folder")}
            }
            state.openNewFolderWindow -> {ShowNewFolderWindow(closeWindow =
                { onEvent(FolderEvent.CloseNewFolderWindow) }, createFolder = {folderName ->
                    onEvent(FolderEvent.SaveNewFolder(folderName))
            })}
            else -> {
                FolderList(folders = state.folders, onFolderClick = { folderId ->
                    onEvent(FolderEvent.FolderOnClick(folderId))})
                IconButton(
                    onClick = {onEvent(FolderEvent.OpenCreateNewFolderWindow)}
                ) { }
            }
        }
    }
}