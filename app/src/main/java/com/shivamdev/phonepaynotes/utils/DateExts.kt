package com.shivamdev.phonepaynotes.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by shivam on 19/01/18.
 */

const val DATE_TIME_PATTERN = "MMM-dd HH:mm a"

fun Date.format(pattern: String): String {
    val date = SimpleDateFormat(pattern, Locale.ENGLISH).format(this)
    return date
}