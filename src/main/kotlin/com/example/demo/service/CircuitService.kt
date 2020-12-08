package com.example.demo.service

/**
 * @author amaltsev
 */
interface CircuitService {
    fun holdTemperature(temperature: Double)

    fun stopHoldTemperature()

    fun getTemperature()

    fun ping()
}