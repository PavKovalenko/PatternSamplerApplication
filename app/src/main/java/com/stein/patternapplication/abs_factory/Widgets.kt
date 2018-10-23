package com.stein.patternapplication.abs_factory

import android.content.Context
import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.ImageView
import com.stein.patternapplication.R

class ClassicButton(context: Context) : Button(context)

class DarkButton(context: Context) : Button(context){

    init{
        setBackgroundColor(ContextCompat.getColor(context, R.color.dark))
    }
}

class ClassicImageView(context: Context) : ImageView(context)

class DarkImageView(context: Context) : ImageView(context){

    init{
        setBackgroundColor(ContextCompat.getColor(context, R.color.dark))
    }
}