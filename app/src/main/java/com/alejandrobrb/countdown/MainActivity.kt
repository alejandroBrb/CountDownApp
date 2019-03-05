package com.alejandrobrb.countdown

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    private var mTimer: TimerImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWidgets()
    }

    override fun setupWidgets() {
        mTimer = TimerImpl(object : CountDownCallback {
            override fun onTick(timeLeft: String) {
                textTimeLeft.text = timeLeft
            }
        })

        buttonStartCountDown.setOnClickListener {
            mTimer?.let { timer ->
                if (timer.isRunning) {
                    timer.stop()
                } else {
                    timer.start()
                }
            }
        }
    }
}
