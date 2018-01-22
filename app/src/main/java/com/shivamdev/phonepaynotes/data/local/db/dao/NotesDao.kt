package com.shivamdev.phonepaynotes.data.local.db.dao

import android.arch.persistence.room.*
import com.shivamdev.phonepaynotes.common.constants.TRUE
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity

/**
 * Created by shivam on 19/01/18.
 */

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NotesEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: NotesEntity)

    @Query("select * from notes")
    fun getNotes(): List<NotesEntity>

    @Query("select * from notes where uid = :id")
    fun getNote(id: Long): NotesEntity

    @Query("select * from notes where is_favourite = $TRUE")
    fun getFavouriteNotes(): List<NotesEntity>

    @Query("select * from notes where is_heart = $TRUE")
    fun getHeartNotes(): List<NotesEntity>

}