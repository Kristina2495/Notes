package com.example.notes.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "notes", foreignKeys = [
    ForeignKey(
        entity = FolderEntity :: class,
        parentColumns = ["id"],
        childColumns = ["folderId"]
    )
], indices = [Index("folderId")])
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val folderId : Int,
    var name : String,
    var text : String,
    val createdAt : Long
)
