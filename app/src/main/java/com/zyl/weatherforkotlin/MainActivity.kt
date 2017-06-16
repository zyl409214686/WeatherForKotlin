package com.zyl.weatherforkotlin

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import com.google.gson.Gson
import com.zyl.weatherforkotlin.weatherapi.BaseData
import com.zyl.weatherforkotlin.weatherapi.Weather
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import java.net.URL

class MainActivity : AppCompatActivity(), AnkoLogger  {
    var mWeatherImageView:ImageView ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //状态栏透明化
        if (Build.VERSION.SDK_INT >= 21) {
            val v = window.decorView
            v.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
//        setContentView(R.layout.activity_main)
        verticalLayout{
            backgroundColor = Color.parseColor("#33ccff")

            textView(R.string.home_title){
                textSize = 20f
                textColor = Color.WHITE
            }.lparams{
                topMargin = dip(10)
                horizontalGravity = Gravity.CENTER_HORIZONTAL
            }
            mWeatherImageView = imageView(R.mipmap.cloudy){
                id = 101010
            }
            fitsSystemWindows = true
        }.layoutParams.height= matchParent
//            val recyclerView = recyclerView();
//            val textView=textView("我是一个TextView")
//            val name = editText("EditText")
//            button("Button") {
//                onClick { toast("${name.text}!") }
//            }
        requestWeather()
    }



    //从服务器加载天气信息
    fun requestWeather() {
        val url = "http://wthrcdn.etouch.cn/weather_mini?citykey=101010100"
        async {
            val s = URL(url).readText()

            uiThread {
                val weather = Gson().fromJson(s, BaseData::class.java)
                //关闭下拉刷新
                debug("content:")
                showWeatherInfo(weather.data.forecast[0])
            }
        }
    }

    fun showWeatherInfo(weather: Weather) {
        if("晴".equals(weather.type)){
            mWeatherImageView?.setImageDrawable(resources.getDrawable(R.mipmap.clear))
        }
        else
            mWeatherImageView?.setImageDrawable(resources.getDrawable(R.mipmap.cloudy))
    }
}
