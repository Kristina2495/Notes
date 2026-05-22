package com.example.notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.data.local.dao.FolderDao
import com.example.notes.data.local.dao.NoteDao
import com.example.notes.data.local.entity.FolderEntity
import com.example.notes.data.local.entity.NoteEntity

@Database(entities = [FolderEntity :: class, NoteEntity :: class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun folderDao() : FolderDao
    abstract fun noteDao() : NoteDao
}