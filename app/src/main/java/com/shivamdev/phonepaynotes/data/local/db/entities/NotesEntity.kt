package com.shivamdev.phonepaynotes.data.local.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by shivam on 19/01/18.
 */
@Entity(tableName = "notes")
data class NotesEntity(@ColumnInfo(name = "title")
                       var title: String,
                       @ColumnInfo(name = "note")
                       var note: String,
                       @ColumnInfo(name = "is_favourite")
                       var isFavourite: Int,
                       @ColumnInfo(name = "is_heart")
                       var isHeart: Int,
                       @ColumnInfo(name = "date_time")
                       var dateTime: String) {

    @ColumnInfo(name = "uid")
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0
}