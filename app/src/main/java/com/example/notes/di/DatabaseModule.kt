package com.example.notes.di
import android.content.Context
import androidx.room.Room
import com.example.notes.data.AppDatabase
import com.example.notes.data.dao.FolderDao
import com.example.notes.data.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent :: class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFolderDao(db : AppDatabase) : FolderDao {
        return db.folderDao()
    }

    @Provides
    @Singleton
    fun provideNoteDao(db : AppDatabase) : NoteDao {
        return db.noteDao()
    }
}