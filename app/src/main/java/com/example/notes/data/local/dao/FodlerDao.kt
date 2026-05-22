package com.example.notes.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notes.data.local.entity.FolderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FolderDao {
    @Insert
    suspend fun insert(folder : FolderEntity)

    @Query("UPDATE folders SET name = :newName WHERE id = :folderId")
    suspend fun updateFolderName(newName : String, folderId : Int)

    @Delete
    suspend fun delete(folder: FolderEntity)

    @Query("SELECT * FROM folders")
    suspend fun getFolders() : Flow<List<FolderEntity>>

}