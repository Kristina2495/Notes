package com.example.notes.presentation.screen.folder_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.repository.FolderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FolderViewModel @Inject constructor(private val folderRepository: FolderRepository)
    : ViewModel() {
    private val _uiState = MutableStateFlow(FolderUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: FolderEvent) {
        when (event) {
            is FolderEvent.LoadFolders -> loadFolders()
            is FolderEvent.FolderOnClick -> Unit
        }
    }

    private fun loadFolders() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            val folders2 = folderRepository.getFolders()

            _uiState.update {
                it.copy(isLoading = false,
                    folders = folders2)
            }


        }
    }


}