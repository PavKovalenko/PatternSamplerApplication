package com.stein.patternapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.stein.patternapplication.abs_factory.ClassicWidgetFactory
import com.stein.patternapplication.abs_factory.DarkWidgetFactory
import com.stein.patternapplication.abs_factory.WidgetAbstractFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var widgetFactory: WidgetAbstractFactory

    private lateinit var darkWidgetFactory: WidgetAbstractFactory
    private lateinit var classicWidgetFactory: WidgetAbstractFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        darkWidgetFactory = DarkWidgetFactory(this)
        classicWidgetFactory = ClassicWidgetFactory(this)

        widgetFactory = classicWidgetFactory

        fillContainer()

        dark.setOnClickListener {
            widgetFactory = darkWidgetFactory
            refreshContainer()
        }
        classic.setOnClickListener {
            widgetFactory = classicWidgetFactory
            refreshContainer()
        }
    }

    private fun refreshContainer() {
        container.removeAllViews()
        fillContainer()
    }

    private fun fillContainer() {
        with(container) {
            addView(widgetFactory.createButton(), getTopLeftParams())
            addView(widgetFactory.createButton(), getTopRightParams())
            addView(widgetFactory.createButton(), getBottomLeftParams())
            addView(widgetFactory.createButton(), getBottomRightParams())

            addView(widgetFactory.createGalleryImageView(), getCenterParams())
        }
    }

    private fun getTopLeftParams() =
        RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    private fun getTopRightParams(): RelativeLayout.LayoutParams {
        val layoutParams =
            RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END)
        return layoutParams
    }

    private fun getBottomLeftParams(): RelativeLayout.LayoutParams {
        val layoutParams =
            RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        return layoutParams
    }

    private fun getBottomRightParams(): RelativeLayout.LayoutParams {
        val layoutParams =
            RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END)
        return layoutParams
    }

    private fun getCenterParams(): RelativeLayout.LayoutParams {
        val layoutParams =
            RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        return layoutParams
    }

}
