package io.github.manuelernesto.gadsleaderboard.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import io.github.manuelernesto.gadsleaderboard.R

@BindingAdapter("picture")
fun loadPicture(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}