package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Notes
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NotesRepository

class DeleteNotesUseCase(
    private val repository : NotesRepository
) {
    suspend operator fun invoke(notes: Notes) {
        repository.deleteNote(notes)
    }
}