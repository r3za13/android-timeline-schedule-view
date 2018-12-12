package com.roundtableapps.timelinedayviewlibrary

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ScrollView

/**
 * @author R3ZA13 (Reza Abedini)
 * @since 9/12/18
 */
class TimeLineLayout : ScrollView {
    private lateinit var horizontalScrollView: HorizontalScrollView

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    {
        horizontalScrollView = HorizontalScrollView(context)
        horizontalScrollView.addView(TimeLineLayoutGroup(context,attrs))
        addView(horizontalScrollView)
        post {
            horizontalScrollView.requestLayout()
        }
    }

    fun <T : Event>addEvent(child: EventView<T>?) {
        (horizontalScrollView.getChildAt(0) as ViewGroup).addView(child)
    }


}