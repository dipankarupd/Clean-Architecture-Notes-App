package com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Notes
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImplementation(
    private val dao: NoteDao
) : NotesRepository {

    override fun getNotes(): Flow<List<Notes>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Notes? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(notes: Notes) {
        return dao.insertNote(notes)
    }

    override suspend fun deleteNode(notes: Notes) {
        return dao.deleteNote(notes)
    }

}