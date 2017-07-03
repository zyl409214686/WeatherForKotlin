package com.zyl.weatherforkotlin.weatherapi

/**
 * Description: 天气API相关数据类
 * Created by zouyulong on 2017/6/16.
 * Job number:147490
 * Phone : 15810880928
 * Email : zouyulong@syswin.com
 * Person in charge :  zouyulong
 * Leader : lixiao
 */
data class Weather(var date:String, var high:String, var low:String, var fengli:String,
                   var type:String)
data class YesterdayWeather(var data:String, var high:String, var low:String, var fl:String,
                   var fx:String, var type:String)
data class Data(var yesterday:YesterdayWeather, var city:String, var api:String,
                var forecast:List<Weather>, var ganmao:String, var wendu:String)
data class BaseData(var data:Data, var status:String, var desc:String)
