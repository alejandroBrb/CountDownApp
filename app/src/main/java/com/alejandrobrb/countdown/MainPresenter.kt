package com.alejandrobrb.countdown

/**
 * @author Alejandro Barba on 2/16/19.
 */

class MainPresenter : MainContract.Presenter {

    private val mTimer: TimerImpl? by lazy {
        TimerImpl(object : CountDownCallback {
            override fun onTick(timeLeft: String) {
                view.updateTime(timeLeft)
            }
        })
    }

    private lateinit var view: MainContract.View

    override fun <V : ViewContract> init(view: V) {
        this.view = view as MainContract.View
    }

    override fun dispatchTimerAction() {
        mTimer?.let { timer ->
            if (timer.isRunning) {
                timer.stop()
                view.startAction()
            } else {
                timer.start()
                view.stopAction()
            }
        }
    }
}