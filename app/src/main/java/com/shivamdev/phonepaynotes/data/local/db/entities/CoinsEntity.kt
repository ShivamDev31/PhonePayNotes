package com.shivamdev.koinexrateticker.data.local.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by shivam on 23/12/17.
 */
@Entity(tableName = "coins_table")
data class CoinsEntity(@ColumnInfo(name = "btc") var btc: Float,
                       @ColumnInfo(name = "eth") var eth: Float,
                       @ColumnInfo(name = "ltc") var ltc: Float,
                       @ColumnInfo(name = "bch") var bch: Float,
                       @ColumnInfo(name = "xrp") var xrp: Float) {

    @ColumnInfo(name = "uid")
    @PrimaryKey(autoGenerate = false)
    var uid: Long = 1002


}