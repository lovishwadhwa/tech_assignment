package com.lovishwadhwa.assignment.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.lovishwadhwa.assignment.services.SignalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SignalControllerTest {

    @Autowired
    private TestRestTemplate client;

    @Autowired
    SignalController signalController;

    @MockBean
    SignalService mockedSignalService;

    @Test
    void shouldCallServiceMethodWithCorrectParameters(){
        doNothing().when(mockedSignalService).handleSignal(any());
        var response = client.postForEntity("/execute/1",null, void.class);

        // Then
        verify(mockedSignalService, times(1)).handleSignal(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}
