package com.shivamdev.phonepaynotes.common.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.koifolio.features.base.Presenter
import com.shivamdev.phonepaynotes.common.NotesApp
import com.shivamdev.phonepaynotes.di.component.ActivityComponent
import com.shivamdev.phonepaynotes.di.component.DaggerActivityComponent
import javax.inject.Inject


abstract class BaseActivity<P : Presenter<*>> : AppCompatActivity() {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        inject(setupActivityComponent())
        attachView()
        initView()
    }

    protected abstract val layout: Int

    protected abstract fun initView()

    protected abstract fun inject(activityComponent: ActivityComponent)

    private fun setupActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .appComponent(NotesApp.instance.component)
                .build()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    protected abstract fun attachView()

    private fun detachView() {
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        detachView()
    }
}