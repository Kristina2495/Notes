package com.example.notes.presentation.screen.note_list

import com.example.notes.presentation.screen.model.NoteItem

data class NoteListUiState (
    val isLoading : Boolean = false,
    val notes : List<NoteItem> = emptyList<NoteItem>(),
    val error : String? = null
)