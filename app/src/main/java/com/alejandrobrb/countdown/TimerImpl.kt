package com.alejandrobrb.countdown

import android.os.CountDownTimer

/**
 * @author Alejandro Barba on 3/4/19.
 */
class TimerImpl(private val countDownCallback: CountDownCallback) : Timer {

    var isRunning: Boolean = false
    var countDownTimer: CountDownTimer? = null
    private var timerFormat: TimerFormat = TimerFormat()

    init {
        countDownTimer = object : CountDownTimer(TIME, SECOND.toLong()) {
            override fun onTick(timeLeft: Long) {
                timerFormat.epoch = timeLeft / SECOND
                countDownCallback.onTick(timerFormat.toBeauty())
            }

            override fun onFinish() {
                isRunning = false
            }
        }
    }

    override fun start() {
        if (isRunning.not()) {
            countDownTimer?.start()
            isRunning = true
        }
    }

    override fun stop() {
        if (isRunning) {
            countDownTimer?.cancel()
            isRunning = false
        }
    }

    companion object {
        private const val SECOND = 1_000
        private const val MINUTE: Int = 60 * SECOND
        private const val HOUR: Int = 60 * MINUTE
        private const val HOURS = 6
        private const val TIME: Long = HOURS * HOUR.toLong()
    }
}