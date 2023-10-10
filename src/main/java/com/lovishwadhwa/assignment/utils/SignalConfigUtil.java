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

    /**
     * Get all the signals from the signalConfig and finds out the steps for the signal given
     * as a parameter, if not found, sends a default step i.e. cancel
     * @param signal
     * @return
     */

    public List<String> getSignalConfig(String signal){
        Map<String, List<String>> allSignalConfigs =  signalConfig.getSignals();
        if (allSignalConfigs.containsKey(signal)){
            return allSignalConfigs.get(signal);
        }
        return List.of("CANCEL");
    }
}
