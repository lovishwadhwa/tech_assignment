package com.lovishwadhwa.assignment.utils;


import com.lovishwadhwa.assignment.config.SignalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SignalConfigUtil {

    @Autowired
    SignalConfig signalConfig;

    public List<String> getSignalConfig(String signal){
        Map<String, List<String>> allSignalConfigs =  signalConfig.getSignals();
        if (allSignalConfigs.containsKey(signal)){
            return allSignalConfigs.get(signal);
        }
        return List.of("cancelTrades");
    }
}
