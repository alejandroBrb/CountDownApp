package com.alejandrobrb.countdown

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWidgets()
    }

    override fun setupWidgets() {
        buttonStartCountDown.setOnClickListener {
            Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show()
        }
    }
}
