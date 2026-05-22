package com.example.notes.navigation

object Routes {
    const val FOLDERS = "folders"
    const val NOTE_LIST = "note_list/{folder_id}"
    fun noteList(folderId : Int) = "note_list/$folderId"
    const val NOTE = "note/{note_id}"
    fun note(noteId : Int) = "note/$noteId"

}