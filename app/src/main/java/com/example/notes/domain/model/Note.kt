package com.example.notes.domain.model

data class Note(
    val id : Int,
    val folderId : Int,
    var name : String,
    var text : String,
    val createdAt : Long
)
