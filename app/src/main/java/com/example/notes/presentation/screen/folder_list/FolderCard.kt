package com.example.notes.presentation.screen.folder_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.notes.presentation.screen.model.FolderItem

@Preview
@Composable
fun FolderCard (@PreviewParameter(FolderProvider :: class) folder : FolderItem,
                onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxSize().fillMaxWidth().clickable{onClick()}) {
        Column (modifier = Modifier.padding(16.dp)) {
            Text(
              text = folder.name
            )
        }
    }

}