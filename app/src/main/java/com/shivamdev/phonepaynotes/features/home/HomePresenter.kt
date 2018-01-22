package com.shivamdev.phonepaynotes.features.home

import com.koifolio.features.base.BasePresenter
import com.shivamdev.phonepaynotes.data.local.db.dao.NotesDao
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity
import javax.inject.Inject

/**
 * Created by shivam on 18/01/18.
 */
class HomePresenter @Inject constructor(private val notesDao: NotesDao) : BasePresenter<HomeView>() {

    fun showNotes() {
        val notes: List<NotesEntity> = notesDao.getNotes()

        if (notes.isNotEmpty()) {
            view?.showNotes(notes)
        } else {
            view?.showNoNotesFoundError()
        }
    }

}