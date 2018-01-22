package com.shivamdev.phonepaynotes.features.notedetails

import com.shivamdev.phonepaynotes.common.mvp.BaseView
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity

/**
 * Created by shivam on 21/01/18.
 */
interface NoteDetailsView : BaseView {
    fun showNoteDetails(note: NotesEntity)
}