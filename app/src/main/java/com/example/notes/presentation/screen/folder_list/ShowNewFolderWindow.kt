package com.example.notes.presentation.screen.folder_list

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog

@Composable
fun ShowNewFolderWindow(closeWindow: () -> Unit, createFolder: (String) -> Unit) {
    var folderName by remember { mutableStateOf("")}
    var folderNameError by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = { closeWindow() }) {
        IconButton(
            onClick = { closeWindow() }
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close"
            )
        }
        Card {
            Column {
                OutlinedTextField(value = folderName, onValueChange = {folderName = it},
                    isError = folderNameError, label = { Text("Type folder name") }
                )
            }
        }

        Button(onClick = {
            folderNameError = folderName.isBlank()
            if (folderNameError) return@Button
            else {createFolder(folderName)} }
        ) {
            Text("Save")
        }

        if (folderNameError) {
            Text("Folder name can't be blank")
        }
    }
}