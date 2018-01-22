package com.shivamdev.phonepaynotes.features.addnote

import com.koifolio.features.base.BasePresenter
import com.shivamdev.phonepaynotes.common.constants.FALSE
import com.shivamdev.phonepaynotes.data.local.db.dao.NotesDao
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity
import com.shivamdev.phonepaynotes.utils.DATE_TIME_PATTERN
import com.shivamdev.phonepaynotes.utils.format
import java.util.*
import javax.inject.Inject

/**
 * Created by shivam on 19/01/18.
 */
class AddEditNotePresenter @Inject constructor(private val notesDao: NotesDao) : BasePresenter<AddEditNoteView>() {

    fun saveNote(title: String, note: String, noteId: Long) {
        val date = Date().format(DATE_TIME_PATTERN)

        val noteEntity = NotesEntity(title, note, FALSE, FALSE, date)
        if (noteId > 0) {
            notesDao.updateNote(noteEntity)
        } else {
            notesDao.insertNote(noteEntity)
        }
        view?.noteSaved()
    }

    fun getNoteData(noteId: Long) {
        val note = notesDao.getNote(noteId)
        view?.showNoteForEditing(note)
    }

}