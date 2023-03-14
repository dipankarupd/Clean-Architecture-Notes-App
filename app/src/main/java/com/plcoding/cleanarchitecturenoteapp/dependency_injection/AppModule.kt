package com.plcoding.cleanarchitecturenoteapp.dependency_injection

import androidx.room.Room
import androidx.room.RoomDatabase
import com.plcoding.cleanarchitecturenoteapp.NotesApp
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NotesRepositoryImplementation
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NotesRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.DeleteNotesUseCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNotesUseCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase (app: NotesApp) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase :: class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDatabase) : NotesRepository {
        return NotesRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNotesUseCases(repository : NotesRepository) : NotesUseCases{
        return NotesUseCases(
            deleteNotesUseCase = DeleteNotesUseCase(repository),
            getNotesUseCase =  GetNotesUseCase(repository)
        )
    }
}