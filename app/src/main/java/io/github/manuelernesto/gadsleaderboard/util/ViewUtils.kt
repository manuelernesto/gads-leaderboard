package io.github.manuelernesto.gadsleaderboard.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import io.github.manuelernesto.gadsleaderboard.R
import kotlinx.android.synthetic.main.custom_alert_layout.view.*

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}


fun customDialog(context: Context, title: String, icon: Int) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    val view = LayoutInflater.from(context).inflate(R.layout.custom_alert_layout,null)
    view.txt_alert.text = title
    view.btn_done.setImageResource(icon)
    builder.setView(view)
    builder.show()
}