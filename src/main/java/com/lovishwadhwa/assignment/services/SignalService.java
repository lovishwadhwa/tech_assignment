package com.lovishwadhwa.assignment.services;

import com.lovishwadhwa.assignment.domain.AlgoMethodEnum;
import com.lovishwadhwa.assignment.externals.Algo;
import com.lovishwadhwa.assignment.utils.SignalConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class SignalService {
    @Autowired
    SignalConfigUtil signalConfigUtil;

    @Autowired
    Algo algo;

    private void simulateSteps(List<String> steps){
        steps.forEach(step -> {
            String[] stepParts = step.split(" ");
            AlgoMethodEnum methodName = AlgoMethodEnum.valueOf(stepParts[0]);
            switch (methodName){
                case SETUP -> {
                    algo.setUp();
                    break;
                }
                case REVERSE -> {
                    algo.reverse();
                    break;
                }
                case CANCEL -> {
                    algo.cancelTrades();
                    break;
                }
                case SUBMIT -> {
                    algo.submitToMarket();
                    break;
                }
                case PERFORM_CAL -> {
                    algo.performCalc();
                    break;
                }
                case SET_PARAM -> {
                    Integer param = Integer.parseInt(stepParts[1]);
                    Integer value = Integer.parseInt(stepParts[2]);
                    algo.setAlgoParam(param, value);
                    break;
                }
                default -> new Exception("Wrong config");
            }
        });
    }

    /**
     * handles the fetching and execution of steps involved with the signal
     * @param signal
     */

    public void handleSignal(Integer signal){
        try{
            List<String> signalConfigSteps = signalConfigUtil.getSignalConfig(signal.toString());
            simulateSteps(signalConfigSteps);
        }
        catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Wrong configuration for " + signal);
        }
    }

}
