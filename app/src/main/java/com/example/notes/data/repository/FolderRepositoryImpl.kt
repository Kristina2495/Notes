package com.example.notes.data.repository

import com.example.notes.domain.model.Folder
import com.example.notes.domain.repository.FolderRepository
import com.example.notes.data.dao.FolderDao
import com.example.notes.data.folderToDomain
import com.example.notes.data.folderToEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FolderRepositoryImpl @Inject constructor (private val folderDao : FolderDao) : FolderRepository {
    override suspend fun insertFolder(folder: Folder) {
        folderDao.insert(folder.folderToEntity())
    }

    override suspend fun delete(folder: Folder) {
        folderDao.delete(folder.folderToEntity())
    }

    override suspend fun getFolders(): Flow<List<Folder>> {
        return folderDao.getFolders().map { folder -> folder.map{ it.folderToDomain()}}
    }

    override suspend fun updateFolderName(newName: String, folderId: Int) {
        folderDao.updateFolderName(newName, folderId)
    }
}