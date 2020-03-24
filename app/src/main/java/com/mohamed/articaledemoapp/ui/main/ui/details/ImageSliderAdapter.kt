package com.mohamed.articaledemoapp.ui.main.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mohamed.articaledemoapp.R
import com.mohamed.articaledemoapp.ui.main.data.model.MediaMetadata
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.item_image.view.*

class ImageSliderAdapter(
    val context: Context,
    private val images: List<MediaMetadata>,
    val onItemChanged: ((position:Int) -> Unit)?
) : SliderViewAdapter<ImageSliderAdapter.ImageSliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderViewHolder {
        return ImageSliderViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        onItemChanged?.invoke(position)
        return super.instantiateItem(container, position)
    }

    override fun onBindViewHolder(viewHolder: ImageSliderViewHolder, position: Int) {
        Glide.with(viewHolder.itemView).load(images[position].url).into(viewHolder.itemView.iv_image)
    }

    override fun getCount(): Int = images.size

    inner class ImageSliderViewHolder(val itemView: View) : ViewHolder(itemView)
}