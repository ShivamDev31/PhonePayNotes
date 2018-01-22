package com.shivamdev.koinexrateticker.data.local.db.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.shivamdev.phonepaynotes.data.local.db.dao.NotesDao
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity

/**
 * Created by shivam on 23/12/17.
 */

@Database(entities = [NotesEntity::class],
        version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}