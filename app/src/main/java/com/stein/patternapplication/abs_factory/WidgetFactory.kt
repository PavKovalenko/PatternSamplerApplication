package com.stein.patternapplication.abs_factory

import android.content.Context
import android.widget.Button
import android.widget.ImageView
import com.stein.patternapplication.R
import com.stein.patternapplication.builder.GalleryImageView

abstract class WidgetAbstractFactory() {
    abstract fun createButton(): Button
    abstract fun createImageView(): ImageView
    abstract fun createGalleryImageView(): GalleryImageView
}

class ClassicWidgetFactory(private val context: Context) : WidgetAbstractFactory() {
    override fun createImageView(): ImageView = ClassicImageView(context)
    override fun createButton(): Button = ClassicButton(context)
    override fun createGalleryImageView(): GalleryImageView = GalleryImageView.Builder(context)
        .setImage(R.drawable.cadillac)
        .addBorder(3)
        .setTitle("Cadillac")
        .setYear("1956")
        .build()
}

class DarkWidgetFactory(private val context: Context) : WidgetAbstractFactory() {
    override fun createImageView(): ImageView = DarkImageView(context)
    override fun createButton(): Button = DarkButton(context)
    override fun createGalleryImageView(): GalleryImageView = GalleryImageView.Builder(context)
        .setImage(R.drawable.dark_cadillac)
        .addBorder(24)
        .setTitle("Black Cadillac")
        .setYear("1958")
        .build()
}