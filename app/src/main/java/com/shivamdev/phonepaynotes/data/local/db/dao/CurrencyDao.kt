package com.shivamdev.koinexrateticker.data.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.shivamdev.koinexrateticker.data.local.db.entities.CurrencyEntity

/**
 * Created by shivam on 30/12/17.
 */
@Dao
interface CurrencyDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencyPrices(currencyEntity: CurrencyEntity)

    @Query("select usd from currency_table")
    fun getUsdPrice(): Float

    @Query("select eur from currency_table")
    fun getEurPrice(): Float

}