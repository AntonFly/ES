package com.example.demo.service.impl

import com.example.demo.vo.HeaterConfig
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

/**
 * @author amaltsev
 */
@Service("emb.configurationDao")
class ConfigurationDao {

    private val storage = ConcurrentHashMap<String, HeaterConfig>()

    fun getConfig(heaterId: String): HeaterConfig {
        return storage[heaterId] ?: throw Exception("Config not found")
    }

    fun setConfig(heaterId: String, config: HeaterConfig) {
        if(storage.contains(heaterId)) {
            throw Exception("Config not found")
        }
        storage[heaterId] = config
    }
}