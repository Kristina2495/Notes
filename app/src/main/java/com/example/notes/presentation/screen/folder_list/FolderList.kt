package com.example.notes.presentation.screen.folder_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.notes.presentation.screen.model.FolderItem

@Composable
fun FolderList(folders : List<FolderItem>, onFolderClick: (Int) -> Unit) {
    LazyColumn {
        items(items = folders, key = {it.id}) {
            folder -> FolderCard(folder = folder, onClick = { onFolderClick(folder.id) })
        }
    }
}