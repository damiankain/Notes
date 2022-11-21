package com.damiankain.mynotes.db

import androidx.lifecycle.LiveData

class NoteRepository (private val noteDao: NoteDao) {
    val getAllData : LiveData<List<Note>> = noteDao.getAllNote()

    suspend fun addNote (note: Note) {
        noteDao.addNote(note)
    }
}