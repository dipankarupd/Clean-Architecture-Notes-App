package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    fun getNotes() : Flow<List<Notes>>

    suspend fun getNoteById(id: Int) : Notes?

    suspend fun insertNote(notes: Notes)

    suspend fun deleteNode(notes: Notes)
}