package com.example.demo.vo

/**
 * @author amaltsev
 */
data class HeaterConfig(
        val temperature: Double,
        val point: Pair<Double, Double>,
        val radius: Double)