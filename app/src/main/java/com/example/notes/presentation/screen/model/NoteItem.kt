package com.example.notes.presentation.screen.model

data class NoteItem (
    val id : Int,
    val folderId : Int,
    var name : String,
    var text : String,
    val createdAt : Long
)