package com.example.notes.data.local.mapper

import com.example.notes.domain.model.Folder
import com.example.notes.domain.model.Note
import com.example.notes.data.local.entity.FolderEntity
import com.example.notes.data.local.entity.NoteEntity

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
    return NoteEntity (
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
    return FolderEntity (
        id = id,
        name = name
    )
}