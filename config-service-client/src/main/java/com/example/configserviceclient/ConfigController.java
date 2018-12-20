package com.example.configserviceclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${config.name}")
    private String configName;

    @GetMapping("/config")
    public String getConfig() {
        return configName;
    }
}
