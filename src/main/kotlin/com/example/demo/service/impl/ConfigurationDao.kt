package com.example.demo.service.impl

import com.example.demo.vo.HeaterConfig
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicReference

/**
 * @author amaltsev
 */
@Service("emb.configurationDao")
class ConfigurationDao {

    private var storage = AtomicReference<HeaterConfig>()

    fun getConfig(): HeaterConfig {
        return storage.get()
    }

    fun setConfig(config: HeaterConfig) {
        storage.set(config)
    }
}