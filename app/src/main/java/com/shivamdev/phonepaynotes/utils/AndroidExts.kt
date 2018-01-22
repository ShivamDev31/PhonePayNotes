package com.koifolio.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

/**
 * Created by shivam on 8/7/17.
 */

inline fun <reified T : Any> Activity.activityStarter() {
    startActivity(intentFor<T>(this))
}

inline fun <reified T : Any> intentFor(context: Context): Intent = Intent(context, T::class.java)

fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(context)
            .load(url)
            .into(this)
}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun View.changeBackgroundColor(@ColorRes color: Int) {
    this.setBackgroundColor(resources.getColor(color))
}

fun TextView.setStringText(@StringRes text: Int) {
    setText(text)
}

fun EditText.setHintText(@StringRes text: Int) {
    hint = resources.getString(text)
}

fun TextView.toText(): String {
    return text.toString()
}

fun EditText.onTextChange(textChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textChanged(s.toString())
        }

    })
}

fun RecyclerView.setup() {
    this.layoutManager = LinearLayoutManager(context)
}