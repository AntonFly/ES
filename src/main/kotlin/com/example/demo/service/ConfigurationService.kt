package com.example.demo.service

import com.example.demo.vo.HeaterConfig

/**
 * @author amaltsev
 */
interface ConfigurationService {
    fun getCurrentConfig(): HeaterConfig?

    fun setConfig(config: HeaterConfig)
}