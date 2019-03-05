package com.alejandrobrb.countdown

/**
 * @author Alejandro Barba on 2/16/19.
 */
interface MainContract {
    interface View : ViewContract {
        fun updateTime(timeLeft : String)

        fun stopAction()

        fun startAction()
    }

    interface Presenter : PresenterContract{
        fun dispatchTimerAction()
    }
}