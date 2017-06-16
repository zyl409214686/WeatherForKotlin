package com.zyl.weatherforkotlin.ui

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.startActivity

class LaunchActivity : AppCompatActivity() {
    var mHandler:LaunchHandler = LaunchHandler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHandler.sendEmptyMessageDelayed(0, 2000)
    }

    inner class LaunchHandler : Handler(){

        override fun handleMessage(msg: Message?) {
            startActivity<MainActivity>()
            finish();
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacksAndMessages(null)
    }
}
