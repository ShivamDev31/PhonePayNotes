package com.shivamdev.phonepaynotes.features.addnote

import com.shivamdev.phonepaynotes.common.mvp.BaseView
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity

/**
 * Created by shivam on 19/01/18.
 */
interface AddEditNoteView : BaseView {
    fun noteSaved()
    fun showNoteForEditing(note: NotesEntity?)
}