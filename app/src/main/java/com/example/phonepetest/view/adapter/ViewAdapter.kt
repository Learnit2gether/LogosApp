package com.example.phonepetest.view.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("srcUri")
fun ImageView.loadUrl(url: String?){
    url?.let { uri ->
        Glide.with(this)
            .load("$url")
            .into(this)
    }
}