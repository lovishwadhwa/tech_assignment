package com.lovishwadhwa.assignment.controllers;

import com.lovishwadhwa.assignment.services.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalController {

    @Autowired
    SignalService signalService;

    /**
     * listens to the post call of /execute/{signal} path
     * @param - path variable signifies the value of signal for which we want to execute the steps
     */
    @PostMapping(value = "/execute/{signal}")
    @ResponseStatus(HttpStatus.OK)
    void executeSignal(@PathVariable("signal") int signal){
        signalService.handleSignal(signal);
    }

}
