package com.example.notes.domain.repository

import com.example.notes.domain.model.Folder
import kotlinx.coroutines.flow.Flow

interface FolderRepository {
    suspend fun insertFolder(folder : Folder)
    suspend fun updateFolderName(newName : String, folderId : Int)
    suspend fun delete(folder: Folder)
    suspend fun getFolders() : Flow<List<Folder>>
}