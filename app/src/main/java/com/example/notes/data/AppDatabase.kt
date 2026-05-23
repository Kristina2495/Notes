package com.example.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.data.dao.FolderDao
import com.example.notes.data.dao.NoteDao
import com.example.notes.data.entity.FolderEntity
import com.example.notes.data.entity.NoteEntity

@Database(entities = [FolderEntity:: class, NoteEntity:: class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun folderDao() : FolderDao
    abstract fun noteDao() : NoteDao
}