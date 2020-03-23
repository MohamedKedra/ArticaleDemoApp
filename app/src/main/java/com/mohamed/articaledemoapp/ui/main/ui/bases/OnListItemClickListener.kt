package com.mohamed.articaledemoapp.ui.main.ui.bases

import android.view.View

interface OnListItemClickListener<T> {

    fun onItemClick(view: View, model: T)
}