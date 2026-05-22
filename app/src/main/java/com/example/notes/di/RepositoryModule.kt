package com.example.notes.di

import com.example.notes.data.local.dao.FolderDao
import com.example.notes.data.local.dao.NoteDao
import com.example.notes.data.repository.FolderRepositoryImpl
import com.example.notes.data.repository.NoteRepositoryImpl
import com.example.notes.domain.repository.FolderRepository
import com.example.notes.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideFolderRepository(folderRepositoryImpl: FolderRepositoryImpl) : FolderRepository

    @Binds
    @Singleton
    abstract fun provideNoteRepository(noteRepositoryImpl: NoteRepositoryImpl) : NoteRepository
}