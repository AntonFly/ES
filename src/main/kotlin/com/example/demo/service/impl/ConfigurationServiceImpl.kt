package com.example.demo.service.impl

import com.example.demo.service.ConfigurationService
import com.example.demo.vo.HeaterConfig
import org.springframework.stereotype.Service

@Service("emb.configurationService")
class ConfigurationServiceImpl(private val configurationDao: ConfigurationDao) : ConfigurationService {
    override fun getConfig(heaterId: String): HeaterConfig {
        return configurationDao.getConfig(heaterId)
    }

    override fun setConfig(heaterId: String, config: HeaterConfig): HeaterConfig {
        configurationDao.setConfig(heaterId, config)
        return configurationDao.getConfig(heaterId)
    }
}