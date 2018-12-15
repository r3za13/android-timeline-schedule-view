package com.roundtableapps.timelinedayviewlibrary

/**
 * @author R3ZA13 (Reza Abedini)
 * @since 18/11/18
 */
open class Event {
    var title: String
    var startTime: Float
    var endTime: Float

    constructor(title: String="",startTime : Float = 0f,endTime: Float = 0f)
    {
        this.title = title
        this.startTime = startTime
        this.endTime = endTime
    }

}