package com.lovishwadhwa.assignment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalController {

    @PostMapping(value = "/execute/{signal}")
    @ResponseStatus(HttpStatus.OK)
    void executeSignal(@PathVariable("signal") int signal){
        System.out.println("Here " + signal);
    }

}
