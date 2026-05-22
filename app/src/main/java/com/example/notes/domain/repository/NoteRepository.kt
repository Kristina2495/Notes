package com.example.notes.domain.repository

import com.example.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertNote(note : Note)
    suspend fun deleteNote(note : Note)
    suspend fun updateNoteName(newText : String, id : Int)
    suspend fun getFolderNotes(folderId : Int) : Flow<List<Note>>
    suspend fun getNote(noteId : Int) : Note?
}