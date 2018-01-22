package com.shivamdev.phonepaynotes.features.home

import com.shivamdev.phonepaynotes.common.mvp.BaseView
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity

/**
 * Created by shivam on 18/01/18.
 */
interface HomeView : BaseView {
    fun showNotes(notes: List<NotesEntity>)
    fun showNoNotesFoundError()

}