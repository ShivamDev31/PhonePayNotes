package com.shivamdev.phonepaynotes.features.addnote

import android.content.Context
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.koifolio.util.toText
import com.shivamdev.phonepaynotes.R
import com.shivamdev.phonepaynotes.common.base.BaseActivity
import com.shivamdev.phonepaynotes.common.constants.KEY_NOTE_ID
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity
import com.shivamdev.phonepaynotes.di.component.ActivityComponent
import kotlinx.android.synthetic.main.activity_add_notes.*

/**
 * Created by shivam on 19/01/18.
 */

class AddEditEditNoteActivity : BaseActivity<AddEditNotePresenter>(), AddEditNoteView {

    private var noteId: Long = -1

    companion object {
        fun startIntent(context: Context, noteId: Long) {
            val intent = Intent(context, AddEditEditNoteActivity::class.java)
            intent.putExtra(KEY_NOTE_ID, noteId)
            context.startActivity(intent)
        }
    }

    override val layout: Int = R.layout.activity_add_notes

    override fun initView() {
        noteId = intent.getLongExtra(KEY_NOTE_ID, -1)
        presenter.getNoteData(noteId)
    }

    override fun showNoteForEditing(note: NotesEntity?) {
        etNoteTitle.setText(note?.title)
        etNote.setText(note?.note)
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun attachView() {
        presenter.attachView(this)
    }

    override fun noteSaved() {
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_note, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.menu_item_save -> {
                val title = etNoteTitle.toText()
                val note = etNote.toText()
                presenter.saveNote(title, note, noteId)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}