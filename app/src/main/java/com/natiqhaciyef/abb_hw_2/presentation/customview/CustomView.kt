package com.natiqhaciyef.abb_hw_2.presentation.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natiqhaciyef.abb_hw_2.R

class CustomView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var colorSelector: Int = R.color.blue

    init {
        inflate(context, R.layout.item_color_selection_layout, this)
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet) {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView, 0, 0
        ).apply {
            colorSelector = getInteger(R.styleable.CustomView_color_selector, R.color.blue)
        }

        refreshView()
    }

    private fun refreshView() {
        val image = findViewById<ImageView>(R.id.imager)
        image.setColorFilter(colorSelector)
    }
}