package com.stein.patternapplication.builder

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.stein.patternapplication.R
import kotlinx.android.synthetic.main.widget_gallery_image.view.*

class GalleryImageView(context: Context) : FrameLayout(context) {

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_gallery_image, this)
    }

    class Builder(context: Context) {
        private val galleryImageView: GalleryImageView = GalleryImageView(context)

        fun setImage(resId: Int): Builder {
            galleryImageView.galleryImage.apply {
                visibility = VISIBLE
                setImageResource(resId)
            }
            return this
        }

        fun setImage(drawable: Drawable): Builder {
            galleryImageView.galleryImage.apply {
                visibility = VISIBLE
                setImageDrawable(drawable)
            }
            return this
        }

        fun setTitle(title: String): Builder {
            galleryImageView.imageTitle.apply {
                visibility = VISIBLE
                setText(title)
            }
            return this
        }

        fun setYear(year: String): Builder {
            galleryImageView.imageYear.apply {
                visibility = VISIBLE
                setText(year)
            }
            return this
        }

        fun addBorder(value: Int): Builder {
            galleryImageView.galleryImage.setPadding(value, value, value, value)
            return this
        }

        fun build(): GalleryImageView {
            return galleryImageView;
        }

    }
}