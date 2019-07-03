package com.example.introslider

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.view.*
class MainActivity : AppCompatActivity() {
    private var runonce: runonce? = null
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        val mainLayout = layoutInflater.inflate(R.layout.activity_main, null)
        super.onCreate(savedInstanceState)
        setContentView(mainLayout)
        this.runonce = runonce(this)
        mainLayout.btn_repeat.setOnClickListener {
            this.runonce!!.isFirstTimeLaunch = true
            restartApp()
        }
    }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun restartApp() {
        val intent = Intent(this, GreetActivity::class.java)
        this.startActivity(intent)
        this.finishAffinity()
    }
}