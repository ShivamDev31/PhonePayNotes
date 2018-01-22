package com.shivamdev.koinexrateticker.data.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.shivamdev.koinexrateticker.data.local.db.entities.CoinsEntity

/**
 * Created by shivam on 23/12/17.
 */

@Dao
interface CoinsDao {

    @Insert(onConflict = REPLACE)
    fun insertCoinPrices(coinsEntity: CoinsEntity)

    @Update(onConflict = REPLACE)
    fun updateCoinPrices(coinsEntity: CoinsEntity)

    @Query("select * from coins_table")
    fun getAllTickers(): List<CoinsEntity>

    @Query("select :coin from coins_table")
    fun getPriceByCoinName(coin: String): Float

    @Query("select btc from coins_table")
    fun getBtcPrice(): Float

    @Query("select eth from coins_table")
    fun getEthPrice(): Float

    @Query("select bch from coins_table")
    fun getBchPrice(): Float

    @Query("select xrp from coins_table")
    fun getXrpPrice(): Float


}