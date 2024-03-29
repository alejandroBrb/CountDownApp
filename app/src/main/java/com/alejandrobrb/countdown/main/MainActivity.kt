package com.alejandrobrb.countdown.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alejandrobrb.countdown.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializePresenter()
        setupWidgets()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.onAttach()
    }

    override fun onPause() {
        super.onPause()
        mainPresenter.onDetach()
    }

    override fun initializePresenter() {
        mainPresenter = MainPresenter()
        mainPresenter.init(this)
    }

    override fun setupWidgets() {
        buttonStartCountDown.setOnClickListener {
            mainPresenter.dispatchTimerAction()
        }
    }

    override fun updateTime(timeLeft: String) {
        textTimeLeft.text = timeLeft
    }

    override fun startAction() {
        // TODO get from resources
        buttonStartCountDown.text = "Iniciar"
    }

    override fun stopAction() {
        // TODO get from resources
        buttonStartCountDown.text = "Detener"
    }
}
