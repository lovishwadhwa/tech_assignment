package com.lovishwadhwa.assignment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "app")
public class SignalConfig {
    private Map<String, List<String>> signals;

    // Getters and setters

    /**
     * Reads the signals config from the signals.yaml file
     * @return
     */
    public Map<String, List<String>> getSignals() {
        return signals;
    }

    public void setSignals(Map<String, List<String>> data) {
        this.signals = data;
    }
}
