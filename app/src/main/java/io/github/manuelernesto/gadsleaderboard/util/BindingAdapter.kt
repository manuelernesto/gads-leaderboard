package io.github.manuelernesto.gadsleaderboard.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import io.github.manuelernesto.gadsleaderboard.R

@BindingAdapter("picture")
fun loadPicture(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .placeholder(R.mipmap.placeholder)
        .error(R.mipmap.placeholder)
        .into(view)
}