package com.example.notes.presentation.screen.folder_list

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.notes.presentation.screen.model.FolderItem

class FolderProvider : PreviewParameterProvider<FolderItem> {
    override val values = sequenceOf(FolderItem(1, "a"),
        FolderItem(2, "b"))
}