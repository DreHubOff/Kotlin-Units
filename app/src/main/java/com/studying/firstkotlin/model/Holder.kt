package com.studying.firstkotlin.model

object  Holder{
    val unitList: Map<String, Double>
    init {
        unitList = HashMap<String, Double>().apply {
            put("millimeter", 1000.0)
            put("centimeter", 100.0)
            put("meter", 1.0)
            put("inch", 39.3701)
            put("foot", 3.28084)
        }
    }
}