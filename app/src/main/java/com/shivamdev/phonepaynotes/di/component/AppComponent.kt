package com.shivamdev.phonepaynotes.di.component


import com.shivamdev.koinexrateticker.data.local.PrefHelper
import com.shivamdev.phonepaynotes.data.local.db.dao.NotesDao
import com.shivamdev.phonepaynotes.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by shivam on 20/7/17.
 */

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun prefHelper(): PrefHelper

    fun notesDao(): NotesDao

}
