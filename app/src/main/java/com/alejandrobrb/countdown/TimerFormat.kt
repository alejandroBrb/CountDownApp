package com.alejandrobrb.countdown

/**
 * @author Alejandro Barba on 3/5/19.
 */
class TimerFormat {

    private var hours: Long = 0
    private var minutes: Long = 0
    private var seconds: Long = 0

    var epoch: Long = 0
        set(value) {
            hours = value / 3_600
            var remainder = value.toInt() - hours * 3_600
            minutes = remainder / 60
            remainder -= minutes * 60
            seconds = remainder
            field = value
        }

    fun toBeauty(): String {
        val hour = String.format("%02d", hours)
        val min = String.format("%02d", minutes)
        val sec = String.format("%02d", seconds)
        return "$hour:$min:$sec"
    }
}