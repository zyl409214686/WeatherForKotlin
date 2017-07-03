package com.zyl.weatherforkotlin.utils

import android.view.ViewManager
import com.zyl.weatherforkotlin.view.AnimRecyclerView
import org.jetbrains.anko.custom.ankoView

/**
 * Description: com.zyl.weatherforkotlin.utils
 * Created by zouyulong on 2017/7/3.
 * Job number:147490
 * Phone : 15810880928
 * Email : zouyulong@syswin.com
 * Person in charge :  zouyulong
 * Leader : lixiao
 */
inline fun ViewManager.myRecyclerView(theme: Int = 0) = myRecyclerView(theme) {}

inline fun ViewManager.myRecyclerView(theme: Int = 0, init: AnimRecyclerView.() -> Unit) = ankoView({ AnimRecyclerView(it) }, theme, init)