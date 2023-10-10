package com.lovishwadhwa.assignment.services;

import org.springframework.stereotype.Service;

@Service
public class SignalService {
    public void handleSignal(int signal){
        System.out.println("From signal service " + signal);
    }

}
