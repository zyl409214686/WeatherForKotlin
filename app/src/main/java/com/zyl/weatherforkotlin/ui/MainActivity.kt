package com.zyl.weatherforkotlin.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ImageView
import com.google.gson.Gson
import com.zyl.weatherforkotlin.R
import com.zyl.weatherforkotlin.utils.myRecyclerView
import com.zyl.weatherforkotlin.view.AnimRecyclerView
import com.zyl.weatherforkotlin.weatherapi.BaseData
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import java.net.URL

class MainActivity : AppCompatActivity(), AnkoLogger {

    var mRecyclerView: AnimRecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //状态栏透明化
        if (Build.VERSION.SDK_INT >= 21) {
            val v = window.decorView
            v.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
        relativeLayout {
            fitsSystemWindows = true
            imageView(R.mipmap.sun_main) {
                scaleType = ImageView.ScaleType.CENTER_CROP
            }.lparams {width = matchParent; height = matchParent}
            verticalLayout {
                textView(R.string.app_name) {
                    textSize = 30f
                }.lparams {
                    topMargin = dip(10)
                    horizontalGravity = Gravity.CENTER_HORIZONTAL
                }

                mRecyclerView = myRecyclerView {
                    layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
                    layoutAnimation = LayoutAnimationController(
                            AnimationUtils.loadAnimation(this@MainActivity, R.anim.slide_in_bottom))
                }.lparams(width = matchParent, height = matchParent){
                    bottomMargin = dip(10)
                }
            }.lparams(width = matchParent, height = matchParent)

        }.layoutParams.height = matchParent
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
                debug("content:" + s)
                mRecyclerView!!.adapter = WeatherAdapter(weather.data.forecast, this@MainActivity)
                mRecyclerView!!.scheduleLayoutAnimation()
            }
        }
    }
}
