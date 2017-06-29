package edu.ubb.academicinfo.util

import android.databinding.BindingAdapter
import android.support.v7.widget.Toolbar

@BindingAdapter("android:title")
fun setTitleTypeface(toolbar: Toolbar, title: String) {
    toolbar.title = title
}