package com.shivamdev.phonepaynotes.features.notedetails

import com.koifolio.features.base.BasePresenter
import com.shivamdev.phonepaynotes.data.local.db.dao.NotesDao
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by shivam on 21/01/18.
 */
class NoteDetailsPresenter @Inject constructor(private val notesDao: NotesDao) : BasePresenter<NoteDetailsView>() {


    fun getNoteDetails(noteId: Long) {
        val note = notesDao.getNote(noteId)
        Timber.i(note.toString())
        view?.showNoteDetails(note)
    }

}