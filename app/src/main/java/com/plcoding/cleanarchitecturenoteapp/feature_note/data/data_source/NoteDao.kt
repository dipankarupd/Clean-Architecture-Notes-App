package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.*
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getNotes() : Flow<List<Notes>>

    @Query("Select * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int) : Notes?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notes: Notes)
    // this will remove the necessity to create another function to add the update feature

    @Delete
    suspend fun deleteNote(notes: Notes)
}