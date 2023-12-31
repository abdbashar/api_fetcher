package com.example.api_fetcher.util

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_fetcher.R
import com.example.api_fetcher.ui.base.BaseAdapter

@BindingAdapter(value = ["app:imageUrl"])
fun loadImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let { url ->
        Glide.with(imageView).load(url).placeholder(R.drawable.loading)
            .error(R.drawable.image_place_holder).into(imageView)
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
    view.scrollToPosition(0)
}

@BindingAdapter("showIfTrue")
fun showIfTrue(view: View, condition: Boolean) {
    view.isVisible = condition
}
