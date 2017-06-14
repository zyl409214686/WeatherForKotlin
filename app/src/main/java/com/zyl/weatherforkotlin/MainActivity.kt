package com.zyl.weatherforkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        verticalLayout {
            val textView=textView("我是一个TextView")
            val name = editText("EditText")
            button("Button") {
                onClick { toast("${name.text}!") }
            }
        }
    }
}
