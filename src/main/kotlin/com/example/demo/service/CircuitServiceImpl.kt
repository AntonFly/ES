package com.example.demo.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

val LOG: Logger = LoggerFactory.getLogger(CircuitServiceImpl::class.java)

@Service("do-nothing-club-service")
class CircuitServiceImpl : CircuitService {
    override fun holdTemperature(temperature: Double) {
        LOG.info("Hold temperature:$temperature")
    }

    override fun stopHoldTemperature() {
        LOG.info("Stop hold temperature")
    }

    override fun getTemperature() {
        LOG.info("getTemperature")
    }

    override fun ping() {
        LOG.info("Ping")
    }
}