package com.shivamdev.phonepaynotes.di.component

import com.instadl.di.scope.PerActivity
import com.shivamdev.phonepaynotes.di.module.ActivityModule
import com.shivamdev.phonepaynotes.features.addnote.AddEditEditNoteActivity
import com.shivamdev.phonepaynotes.features.home.HomeActivity
import com.shivamdev.phonepaynotes.features.notedetails.NoteDetailsActivity
import com.shivamdev.phonepaynotes.features.splash.SplashActivity
import dagger.Component

/**
 * Created by shivam on 20/7/17.
 */

@PerActivity
@Component(dependencies = [(AppComponent::class)],
        modules = [(ActivityModule::class)])
interface ActivityComponent {
    fun inject(splashActivity: SplashActivity)
    fun inject(homeActivity: HomeActivity)
    fun inject(addNoteActivity: AddEditEditNoteActivity)
    fun inject(noteDetailsActivity: NoteDetailsActivity)

}