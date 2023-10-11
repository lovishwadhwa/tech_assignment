package com.lovishwadhwa.assignment.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.lovishwadhwa.assignment.config.SignalConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class SignalConfigUtilTest {

    @Autowired
    SignalConfigUtil signalConfigUtil;

    @MockBean
    SignalConfig signalConfig;

    @Test
    void shouldReturnCorrectStepsFromConfig(){
        when(signalConfig.getSignals()).thenReturn(
                Map.of(
                        "1",
                        List.of("REVERSE", "SETUP")
                )
        );

        List<String> configSteps = signalConfigUtil.getSignalConfig("1");

        assertEquals(configSteps, List.of("REVERSE", "SETUP"));

        List<String> cancelConfigSteps = signalConfigUtil.getSignalConfig("2");

        assertEquals(cancelConfigSteps, List.of("CANCEL"));
    }

    @Test
    void shouldReturnDefaultStepsIfSignalNotFound(){
        when(signalConfig.getSignals()).thenReturn(
                Map.of(
                        "1",
                        List.of("REVERSE", "SETUP")
                )
        );

        List<String> cancelConfigSteps = signalConfigUtil.getSignalConfig("2");

        assertEquals(cancelConfigSteps, List.of("CANCEL"));
    }
}
