package com.lovishwadhwa.assignment.controllers;

import com.lovishwadhwa.assignment.services.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignalController {

    @Autowired
    SignalService signalService;

    @GetMapping (value = "/execute/{signal}")
    @ResponseStatus(HttpStatus.OK)
    void executeSignal(@PathVariable("signal") int signal){
        signalService.handleSignal(signal);
    }

}
