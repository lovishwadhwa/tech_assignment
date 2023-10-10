package com.lovishwadhwa.assignment.services;

import com.lovishwadhwa.assignment.utils.SignalConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalService {
    @Autowired
    SignalConfigUtil signalConfigUtil;

    public void handleSignal(int signal){
        String signalConfigSteps = signalConfigUtil.getSignalConfig(signal);
        System.out.println("From signal service " + signal);
    }

}
