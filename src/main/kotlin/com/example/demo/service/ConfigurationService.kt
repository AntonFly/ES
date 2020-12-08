package com.example.demo.service

import com.example.demo.vo.HeaterConfig

/**
 * @author amaltsev
 */
interface ConfigurationService {
    fun getConfig(heaterId: String): HeaterConfig?

    fun setConfig(heaterId: String, config: HeaterConfig): HeaterConfig
}