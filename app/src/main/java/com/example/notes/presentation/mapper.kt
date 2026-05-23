package com.example.notes.presentation

import com.example.notes.domain.model.Folder
import com.example.notes.presentation.screen.folder_list.FolderUiState
import com.example.notes.presentation.screen.model.FolderItem

fun FolderItem.toDomain() : Folder {
    return Folder(
        id = id,
        name = name
    )
}

fun Folder.toModel() : FolderItem {
    return FolderItem (
        id = id,
        name = name
    )
}

