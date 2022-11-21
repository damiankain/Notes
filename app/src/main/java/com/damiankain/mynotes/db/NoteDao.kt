package com.damiankain.mynotes.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNote(): LiveData<List<Note>>
}