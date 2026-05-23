package com.example.notes.data.repository

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository
import com.example.notes.data.dao.NoteDao
import com.example.notes.data.noteToDomain
import com.example.notes.data.noteToEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor (private val noteDao : NoteDao) : NoteRepository {
    override suspend fun insertNote(note: Note) {
        noteDao.insert(note.noteToEntity())
    }

    override suspend fun deleteNote(note: Note) {
         noteDao.delete(note.noteToEntity())
    }

    override suspend fun getFolderNotes(folderId: Int): Flow<List<Note>> {
        return noteDao.getFolderNotes(folderId).map { notes -> notes.map {it.noteToDomain()} }
    }

    override suspend fun getNote(noteId: Int): Note? {
        return noteDao.getNote(noteId)?.noteToDomain()
    }

    override suspend fun updateNoteName(newText: String, id: Int) {
        noteDao.updateNoteText(newText, id)
    }
}