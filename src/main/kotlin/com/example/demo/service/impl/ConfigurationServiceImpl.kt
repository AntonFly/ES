package com.example.demo.service.impl

import com.example.demo.service.ConfigurationService
import com.example.demo.vo.HeaterConfig
import org.springframework.stereotype.Service

@Service("emb.configurationService")
class ConfigurationServiceImpl(private val configurationDao: ConfigurationDao) : ConfigurationService {
    override fun getCurrentConfig(): HeaterConfig {
        return configurationDao.getConfig()
    }

    override fun setConfig(config: HeaterConfig) {
        configurationDao.setConfig(config)
    }
}