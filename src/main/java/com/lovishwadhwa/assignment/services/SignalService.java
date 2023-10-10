package com.lovishwadhwa.assignment.services;

import com.lovishwadhwa.assignment.utils.SignalConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalService {
    @Autowired
    SignalConfigUtil signalConfigUtil;

    public void handleSignal(Integer signal){
        List<String> signalConfigSteps = signalConfigUtil.getSignalConfig(signal.toString());
        System.out.println("From signal service " + signalConfigSteps);
    }

}
