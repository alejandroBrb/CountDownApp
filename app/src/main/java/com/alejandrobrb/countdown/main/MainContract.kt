package com.alejandrobrb.countdown.main

import com.alejandrobrb.countdown.PresenterContract
import com.alejandrobrb.countdown.ViewContract

/**
 * @author Alejandro Barba on 2/16/19.
 */
interface MainContract {
    interface View : ViewContract {
        fun updateTime(timeLeft : String)

        fun stopAction()

        fun startAction()
    }

    interface Presenter : PresenterContract {
        fun dispatchTimerAction()
    }
}