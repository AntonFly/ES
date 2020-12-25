package com.example.demo.service.impl

import com.example.demo.service.ConfigurationService
import com.example.demo.vo.GetConfigRequest
import com.example.demo.vo.HeaterConfig
import com.example.demo.vo.HoldTemperatureRequest
import com.example.demo.vo.SetConfigRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @author amaltsev
 */
@RestController
class MainController(val configurationService: ConfigurationService) {

    private var hold = AtomicBoolean(false)

    @GetMapping("get/config")
    fun getConfig(request: GetConfigRequest): HeaterConfig =
            configurationService.getCurrentConfig() ?: throw Exception("Please set heater config")

    @PostMapping("set/config")
    fun setConfig(@RequestBody request: SetConfigRequest) {
        configurationService.setConfig(request.config)
    }

    @GetMapping("temperature/stop")
    fun holdTemperature() {
        hold.set(true)
    }

    @GetMapping("temperature/hold")
    fun stopHoldTemperature() {
        hold.set(false)
    }

    @GetMapping("heater/temp")
    fun getTemperatureToHold(request: HoldTemperatureRequest): Double? {
        return configurationService.getCurrentConfig()?.temperature ?: 0.0
    }
}