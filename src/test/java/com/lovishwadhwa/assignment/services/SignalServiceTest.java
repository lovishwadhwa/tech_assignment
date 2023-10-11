package com.lovishwadhwa.assignment.services;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.lovishwadhwa.assignment.externals.Algo;
import com.lovishwadhwa.assignment.utils.SignalConfigUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@WebMvcTest(SignalService.class)
public class SignalServiceTest {

    @Autowired
    SignalService signalService;

    @MockBean
    SignalConfigUtil signalConfigUtil;

    @MockBean
    Algo algo;

    @Test
    void shouldExecuteStepsForGivenSignalWithValidConfig(){
        when(signalConfigUtil.getSignalConfig(any())).thenReturn(
                List.of(
                        "SETUP",
                        "REVERSE",
                        "PERFORM_CAL",
                        "SUBMIT",
                        "CANCEL",
                        "SET_PARAM 1 60"
                )
        );
        doNothing().when(algo).setAlgoParam(anyInt(), anyInt());
        doNothing().when(algo).performCalc();
        doNothing().when(algo).cancelTrades();
        doNothing().when(algo).reverse();
        doNothing().when(algo).setUp();
        doNothing().when(algo).submitToMarket();
        doNothing().when(algo).doAlgo();


        signalService.handleSignal(1);

        verify(algo, times(1)).submitToMarket();
        verify(algo, times(1)).setUp();
        verify(algo, times(1)).reverse();
        verify(algo, times(1)).cancelTrades();
        verify(algo, times(1)).performCalc();
        verify(algo, times(1)).doAlgo();
        verify(algo, times(1)).setAlgoParam(1, 60);

    }

    @Test
    void shouldThrowExceptionForGivenSignalWithInvalidConfig(){
        when(signalConfigUtil.getSignalConfig(any())).thenReturn(
                List.of(
                        "INVALID"
                )
        );


        assertThrows(HttpClientErrorException.class, () -> signalService.handleSignal(1));

    }
}
