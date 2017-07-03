package com.zyl.weatherforkotlin.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.LayoutAnimationController



/**
 * Description: com.zyl.weatherforkotlin.view
 * Created by zouyulong on 2017/7/3.
 * Job number:147490
 * Phone : 15810880928
 * Email : zouyulong@syswin.com
 * Person in charge :  zouyulong
 * Leader : lixiao
 */
class AnimRecyclerView : RecyclerView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun setLayoutManager(layout: LayoutManager?) {
        if (layout is LinearLayoutManager) {
            super.setLayoutManager(layout); } else {
            throw  ClassCastException("请使用LinearLayoutManager"); }
    }

    override fun attachLayoutAnimationParameters(child: View?, params: ViewGroup.LayoutParams?, index: Int, count: Int) {
        if (adapter != null && layoutManager is LinearLayoutManager) {
            var animationParameters: LayoutAnimationController.AnimationParameters? = params!!.layoutAnimationParameters
            if (animationParameters == null) {
                val alphaAnimation = AlphaAnimation(0f, 1f)
                alphaAnimation.duration = 1000
                animationParameters = LayoutAnimationController.AnimationParameters()
                params!!.layoutAnimationParameters = animationParameters
            }
            animationParameters.count = count
            animationParameters.index = index
        } else {
            super.attachLayoutAnimationParameters(child, params, index, count)
        }
    }
}