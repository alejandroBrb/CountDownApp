package com.alejandrobrb.countdown

/**
 * @author Alejandro Barba on 3/5/19.
 */
interface PresenterContract {
    fun <V : ViewContract> init(view: V)
}