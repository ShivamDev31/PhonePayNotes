package com.shivamdev.phonepaynotes.features.notedetails

import android.content.Context
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.shivamdev.phonepaynotes.R
import com.shivamdev.phonepaynotes.common.base.BaseActivity
import com.shivamdev.phonepaynotes.common.constants.KEY_NOTE_ID
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity
import com.shivamdev.phonepaynotes.di.component.ActivityComponent
import com.shivamdev.phonepaynotes.features.addnote.AddEditEditNoteActivity
import kotlinx.android.synthetic.main.activity_note_details.*


/**
 * Created by shivam on 21/01/18.
 */
class NoteDetailsActivity : BaseActivity<NoteDetailsPresenter>(), NoteDetailsView {

    private var noteId: Long = -1

    companion object {
        fun startIntent(context: Context, noteId: Long) {
            val intent = Intent(context, NoteDetailsActivity::class.java)
            intent.putExtra(KEY_NOTE_ID, noteId)
            context.startActivity(intent)
        }
    }

    override fun showNoteDetails(note: NotesEntity) {
        tvNoteTitle.text = note.title
        tvNoteDetails.text = note.note
    }

    override val layout: Int = R.layout.activity_note_details

    override fun initView() {
        noteId = intent.getLongExtra(KEY_NOTE_ID, 0)
        presenter.getNoteDetails(noteId)
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun attachView() {
        presenter.attachView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (noteId > 0) {
            menuInflater.inflate(R.menu.menu_note_details, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.menu_edit_note -> {
                AddEditEditNoteActivity.startIntent(this, noteId)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}