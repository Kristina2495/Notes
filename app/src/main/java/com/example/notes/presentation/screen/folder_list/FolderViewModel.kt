package com.example.notes.presentation.screen.folder_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.model.Folder
import com.example.notes.domain.repository.FolderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.notes.presentation.toModel
import kotlinx.coroutines.flow.toList

@HiltViewModel
class FolderViewModel @Inject constructor(private val folderRepository: FolderRepository)
    : ViewModel() {
    private val _uiState = MutableStateFlow(FolderUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: FolderEvent) {
        when (event) {
            is FolderEvent.LoadFolders -> loadFolders()
            is FolderEvent.FolderOnClick -> Unit
            is FolderEvent.OpenCreateNewFolderWindow -> openCreateNewFolderWindow()
            is FolderEvent.SaveNewFolder -> saveNewFolder(event.folderName)
            is FolderEvent.CloseNewFolderWindow -> closeNewFolderWindow()
        }
    }

    private fun loadFolders() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            val folders = folderRepository.getFolders()

            _uiState.update {
                it.copy(isLoading = false,
                    folders = folders.toList().flatten().map { folder -> folder.toModel() })
            }


        }
    }

    private fun openCreateNewFolderWindow() {
        _uiState.update {
            it.copy(openNewFolderWindow = true)
        }
    }

    private fun closeCreateNewFolderWindow() {
        _uiState.update {
            it.copy(openNewFolderWindow = false)
        }
    }

    private fun saveNewFolder(folderName : String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(savingNewFolder = true)
            }

            folderRepository.insertFolder(Folder(id = 0, name = folderName))

            _uiState.update {
                it.copy(savingNewFolder = false, openNewFolderWindow = false)
            }
        }
    }

    private fun closeNewFolderWindow() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(openNewFolderWindow = false)
            }
        }
    }


}