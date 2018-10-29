package com.stein.patternapplication.builder

import android.content.Context
import android.support.constraint.ConstraintLayout

class GalleryImageView(context: Context) : ConstraintLayout(context) {


    class Builder(private val context: Context) {

        fun build(): GalleryImageView {

            //todo finished continue to build builder layout

            return GalleryImageView(context);
        }

    }
}