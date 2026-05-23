package com.example.notes.data

import com.example.notes.data.entity.FolderEntity
import com.example.notes.data.entity.NoteEntity
import com.example.notes.domain.model.Folder
import com.example.notes.domain.model.Note

fun NoteEntity.noteToDomain() : Note {
    return Note (
        id = id,
        folderId = folderId,
        name = name,
        text = text,
        createdAt = createdAt
    )
}

fun Note.noteToEntity() : NoteEntity {
    return NoteEntity(
        id = id,
        folderId = folderId,
        name = name,
        text = text,
        createdAt = createdAt
    )
}

fun FolderEntity.folderToDomain() : Folder {
    return Folder(
        id = id,
        name = name
    )
}

fun Folder.folderToEntity() : FolderEntity {
    return FolderEntity(
        id = id,
        name = name
    )
}