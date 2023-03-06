package com.salihkinali.core.design.extension

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.downloadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}

fun View.show(){
    this.visibility =View.VISIBLE
}
fun View.hide(){
    this.visibility =View.GONE
}
