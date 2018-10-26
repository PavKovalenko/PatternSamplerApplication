package com.stein.patternapplication.abs_factory

import android.content.Context
import android.widget.Button
import android.widget.ImageView

abstract class WidgetAbstractFactory() {
    abstract fun createButton(): Button
    abstract fun createImageView(): ImageView
}

class ClassicWidgetFactory(private val context: Context) : WidgetAbstractFactory() {
    override fun createImageView(): ImageView = ClassicImageView(context)
    override fun createButton(): Button = ClassicButton(context)
}

class DarkWidgetFactory(private val context: Context) : WidgetAbstractFactory() {

    override fun createImageView(): ImageView = DarkImageView(context)

    override fun createButton(): Button = DarkButton(context)

}