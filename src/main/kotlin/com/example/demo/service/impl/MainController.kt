package com.example.demo.service.impl

import com.example.demo.service.CircuitService
import com.example.demo.service.ConfigurationService
import com.example.demo.vo.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author amaltsev
 */
@RestController
class MainController(val circuitService: CircuitService,
                     val configurationService: ConfigurationService) {

    @GetMapping("connect")
    fun connect(@RequestBody request: ConnectHeaterRequest): ConnectHeaterResponse {
        val config = configurationService.getConfig(request.heaterId)
        return ConnectHeaterResponse(
                PointVo(1.0, 2.0),
                config!!)
    }

    @GetMapping("get/config")
    fun getConfig(request: GetConfigRequest): HeaterConfig =
            configurationService.getConfig(request.heaterId) ?: throw Exception("Heater with provided 'id' isn't found")

    @GetMapping("set/config")
    fun setConfig(request: SetConfigRequest) {
        val config = configurationService.setConfig(request.heaterId, request.config)
        circuitService.holdTemperature(config.temperature)
    }

    @GetMapping("heater/hold")
    fun holdTemperature(request: HoldTemperatureRequest) {
        circuitService.holdTemperature(request.temperature)
    }

    @GetMapping("heater/stop")
    fun stopHoldTemperature() {
        circuitService.stopHoldTemperature()
    }
}