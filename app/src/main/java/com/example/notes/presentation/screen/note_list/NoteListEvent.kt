package com.example.notes.presentation.screen.note_list

sealed interface NoteListEvent {
    data class loadNotes(val folder)
}