package com.shivamdev.phonepaynotes.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.shivamdev.koinexrateticker.data.local.db.database.AppDatabase
import com.shivamdev.phonepaynotes.common.constants.PREF_FILE_NAME
import com.shivamdev.phonepaynotes.data.local.db.dao.NotesDao
import com.shivamdev.phonepaynotes.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module//(includes = [(ApiModule::class)])
class AppModule(private val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "notes-db")
                .allowMainThreadQueries()
                .build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(database: AppDatabase): NotesDao {
        return database.notesDao()
    }
}