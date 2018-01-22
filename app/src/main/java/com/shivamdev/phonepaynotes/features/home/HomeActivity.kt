package com.shivamdev.phonepaynotes.features.home

import android.view.Menu
import android.view.MenuItem
import com.koifolio.util.setup
import com.shivamdev.phonepaynotes.R
import com.shivamdev.phonepaynotes.common.base.BaseActivity
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity
import com.shivamdev.phonepaynotes.di.component.ActivityComponent
import com.shivamdev.phonepaynotes.features.addnote.AddEditEditNoteActivity
import com.shivamdev.phonepaynotes.features.home.adapter.HomeNotesAdapter
import com.shivamdev.phonepaynotes.features.notedetails.NoteDetailsActivity
import kotlinx.android.synthetic.main.activity_home.*
import timber.log.Timber

/**
 * Created by shivam on 18/01/18.
 */
class HomeActivity : BaseActivity<HomePresenter>(), HomeView {

    override val layout: Int = R.layout.activity_home

    var notesAdapter = HomeNotesAdapter()

    override fun initView() {
        rvNotes.setup()
        rvNotes.adapter = notesAdapter
        presenter.showNotes()
        setupNoteClickListener()
    }

    private fun setupNoteClickListener() {
        notesAdapter.getClickSubject()
                .subscribe({
                    Timber.i("Note id $it")
                    NoteDetailsActivity.startIntent(this, it)
                })
    }

    override fun showNotes(notes: List<NotesEntity>) {
        notesAdapter.updateNotes(notes)
    }

    override fun showNoNotesFoundError() {

    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun attachView() {
        presenter.attachView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.menu_add_note -> {
                AddEditEditNoteActivity.startIntent(this, -1)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}