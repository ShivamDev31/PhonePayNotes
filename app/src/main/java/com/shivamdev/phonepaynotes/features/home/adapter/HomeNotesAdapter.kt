package com.shivamdev.phonepaynotes.features.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shivamdev.phonepaynotes.R
import com.shivamdev.phonepaynotes.common.constants.TRUE
import com.shivamdev.phonepaynotes.data.local.db.entities.NotesEntity
import kotlinx.android.synthetic.main.item_note.view.*
import rx.subjects.PublishSubject

/**
 * Created by shivam on 19/01/18.
 */
class HomeNotesAdapter : RecyclerView.Adapter<HomeNotesAdapter.HomeNotesHolder>() {

    private val notes = mutableListOf<NotesEntity>()

    private val clickSubject = PublishSubject.create<Long>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeNotesHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_note, parent,
                false)
        return HomeNotesHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: HomeNotesHolder?, position: Int) {
        holder?.bind(notes[position])
    }

    fun updateNotes(notes: List<NotesEntity>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }

    fun getClickSubject(): PublishSubject<Long> {
        return clickSubject
    }

    inner class HomeNotesHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val context: Context = itemView.context

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(notesEntity: NotesEntity) {
            itemView?.tvNoteTitle?.text = notesEntity.title
            itemView?.tvNote?.text = notesEntity.note

            if (notesEntity.isFavourite == TRUE) {
                itemView?.ivFavourite?.setImageDrawable(context
                        .resources.getDrawable(R.drawable.ic_heart_fill))
            } else {
                itemView?.ivFavourite?.setImageDrawable(context
                        .resources.getDrawable(R.drawable.ic_heart_border))
            }

            if (notesEntity.isHeart == TRUE) {
                itemView?.ivHeart?.setImageDrawable(context
                        .resources.getDrawable(R.drawable.ic_star_fill))
            } else {
                itemView?.ivHeart?.setImageDrawable(context
                        .resources.getDrawable(R.drawable.ic_star_border))
            }
        }

        override fun onClick(v: View?) {
            clickSubject.onNext(notes[adapterPosition].uid)
        }
    }

}