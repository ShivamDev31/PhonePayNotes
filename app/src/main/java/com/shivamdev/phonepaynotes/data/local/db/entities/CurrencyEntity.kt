package com.shivamdev.koinexrateticker.data.local.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by shivam on 30/12/17.
 */

@Entity(tableName = "currency_table")
data class CurrencyEntity(@ColumnInfo(name = "usd") var usd: Float,
                          @ColumnInfo(name = "eur") var eur: Float) {

    @ColumnInfo(name = "uid")
    @PrimaryKey(autoGenerate = false)
    var uid: Long = 1002

}