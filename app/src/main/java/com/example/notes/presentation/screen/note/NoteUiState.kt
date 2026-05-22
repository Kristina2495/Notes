package com.example.notes.presentation.screen.note

import com.example.notes.presentation.screen.model.NoteItem

data class NoteUiState (
    val isLoading : Boolean = false,
    val note : NoteItem? = null,
    val error : String? = null
)