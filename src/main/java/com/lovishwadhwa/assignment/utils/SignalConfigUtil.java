package com.lovishwadhwa.assignment.utils;


import com.lovishwadhwa.assignment.config.SignalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalConfigUtil {

    @Autowired
    SignalConfig signalConfig;

    public String getSignalConfig(int signal){
        System.out.println(signalConfig.getSignals());
        return signalConfig.getSignals().toString();
    }
}
