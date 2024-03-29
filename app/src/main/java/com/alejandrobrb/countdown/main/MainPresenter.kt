package com.alejandrobrb.countdown.main

import com.alejandrobrb.countdown.CountDownCallback
import com.alejandrobrb.countdown.TimerImpl
import com.alejandrobrb.countdown.ViewContract
import timber.log.Timber

/**
 * @author Alejandro Barba on 2/16/19.
 */

class MainPresenter : MainContract.Presenter {

    private val mTimer: TimerImpl? by lazy {
        TimerImpl(object : CountDownCallback {
            override fun onTick(timeLeft: String) {
                view?.updateTime(timeLeft)
            }
        })
    }

    private var view: MainContract.View? = null

    override fun <V : ViewContract> init(view: V) {
        this.view = view as? MainContract.View
    }

    override fun onAttach() {
        Timber.d("Recover time left")
    }

    override fun onDetach() {
        Timber.d("Save time left")
    }

    override fun dispatchTimerAction() {
        mTimer?.let { timer ->
            if (timer.isRunning) {
                timer.stop()
                view?.startAction()
            } else {
                timer.start()
                view?.stopAction()
            }
        }
    }
}