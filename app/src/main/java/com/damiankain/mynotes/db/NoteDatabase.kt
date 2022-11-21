package com.damiankain.mynotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private var database: NoteDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): NoteDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java, "database"
                ).build()
                database as NoteDatabase
            } else {
                database as NoteDatabase
            }
        }
    }
}