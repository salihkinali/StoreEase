package com.salihkinali.core.design.extension

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.downloadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}