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
            hours = value / MINUTES_SECONDS
            var remainder = value.toInt() - hours * MINUTES_SECONDS
            minutes = remainder / MINUTES
            remainder -= minutes * MINUTES
            seconds = remainder
            field = value
        }

    fun toBeauty(): String {
        val hour = String.format("%02d", hours)
        val min = String.format("%02d", minutes)
        val sec = String.format("%02d", seconds)
        return "$hour:$min:$sec"
    }

    companion object {
        const val MINUTES_SECONDS = 3_600
        const val MINUTES = 60
    }
}