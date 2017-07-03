package com.zyl.weatherforkotlin.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zyl.weatherforkotlin.R
import com.zyl.weatherforkotlin.weatherapi.Weather

/**
 * Description: com.zyl.weatherforkotlin.ui
 * Created by zouyulong on 2017/7/3.
 * Job number:147490
 * Phone : 15810880928
 * Email : zouyulong@syswin.com
 * Person in charge :  zouyulong
 * Leader : lixiao
 */


class WeatherAdapter : Adapter<WeatherAdapter.MyHolder> {
    var mData: List<Weather>? = null
    var mContext: Context? = null
    val TYPE_FINE = "晴"
    val TYPE_CLOUDY = "多云"
    val TYPE_OVERCAST = "阴"
    val TYPE_SHOWER = "阵雨"
    val TYPE_RAINSTORM = "暴雨"
    val TYPE_HEAVY_RAIN = "大雨"
    val TYPE_MODERATE_RAIN = "中雨"
    val TYPE_SPRINKLE = "小雨"
    val TYPE_THUNDERSHOWER = "雷阵雨"
    val TYPE_HEAVY_SNOWFALL = "暴雪"
    val TYPE_HEAVY_SNOW = "大雪"
    val TYPE_MODERATE_SNOW = "中雪"
    val TYPE_SCOUTHER = "小雪"
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        var weather:Weather = mData!!.get(position)
        refreshUIForWeather(holder, weather)
        holder!!.dateTv.setText(weather.date)
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        var v: View = LayoutInflater.from(mContext).inflate(R.layout.item_weather, parent, false)
        var holder = MyHolder(v)
        return holder
    }

    constructor(mData: List<Weather>?, mContext: Context?) {
        this.mData = mData
        this.mContext = mContext
    }

    fun refreshUIForWeather(holder: MyHolder?, weather:Weather){
        var type = weather.type
        if(TYPE_FINE.equals(type)){
            holder!!.weatherIv?.setImageResource(R.mipmap.clear)
            holder!!.weatherTv.setText(TYPE_FINE)
        }
        else if(TYPE_CLOUDY.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.cloudy)
            holder!!.weatherTv.setText(TYPE_CLOUDY)
        }
        else if(TYPE_OVERCAST.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_cloudy)
            holder!!.weatherTv.setText(TYPE_OVERCAST)
        }
        else if(TYPE_SHOWER.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_one_rain)
            holder!!.weatherTv.setText(TYPE_SHOWER)
        }
        else if(TYPE_SPRINKLE.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_one_rain)
            holder!!.weatherTv.setText(TYPE_SPRINKLE)
        }
        else if(TYPE_THUNDERSHOWER.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_one_thunder_rain)
            holder!!.weatherTv.setText(TYPE_THUNDERSHOWER)
        }
        else if(TYPE_MODERATE_RAIN.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_one_heavy_rain)
            holder!!.weatherTv.setText(TYPE_THUNDERSHOWER)
        }
        else if(TYPE_HEAVY_RAIN.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_one_heavy_rain)
            holder!!.weatherTv.setText(TYPE_HEAVY_RAIN)
        }
        else if(TYPE_RAINSTORM.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_one_heavy_rain)
            holder!!.weatherTv.setText(TYPE_RAINSTORM)
        }

        else if(TYPE_SCOUTHER.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_one_snow)
            holder!!.weatherTv.setText(TYPE_SCOUTHER)
        }
        else if(TYPE_MODERATE_SNOW.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_two_snow)
            holder!!.weatherTv.setText(TYPE_MODERATE_SNOW)
        }
        else if(TYPE_HEAVY_SNOW.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_two_snow)
            holder!!.weatherTv.setText(TYPE_HEAVY_SNOW)
        }
        else if(TYPE_HEAVY_SNOWFALL.equals(type)) {
            holder!!.weatherIv?.setImageResource(R.mipmap.type_two_snow)
            holder!!.weatherTv.setText(TYPE_HEAVY_SNOWFALL)
        }
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var weatherIv: ImageView = itemView!!.findViewById(R.id.iv_weather) as ImageView
        var weatherTv: TextView = itemView!!.findViewById(R.id.tv_weather) as TextView
        var dateTv: TextView = itemView!!.findViewById(R.id.tv_date) as TextView
//        var txtName: TextView = itemView!!.findViewById(R.id.txtName) as TextView;
//        var bonus: TextView = itemView!!.findViewById(R.id.bonus) as TextView;
    }

}