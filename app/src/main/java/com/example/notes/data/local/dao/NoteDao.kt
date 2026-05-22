package com.example.notes.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notes.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note : NoteEntity)

    @Delete
    suspend fun delete(note : NoteEntity)

    @Query("UPDATE notes SET name = :newName WHERE id = :id")
    suspend fun updateNoteName(newName : String, id : Int)

    @Query("UPDATE notes SET text = :newText WHERE id = :id")
    suspend fun updateNoteText(newText : String, id : Int)

    @Query("SELECT * FROM notes WHERE folderId = :folderId")
    suspend fun getFolderNotes(folderId : Int) : Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNote(noteId : Int) : NoteEntity?
}