package com.ucx.testsparttwo.bugFix;

import org.springframework.stereotype.Component;

@Component
public class LogService {
    private LogBean logBean;
    public LogService(LogBean logBean){
        this.logBean = logBean;
    }

    public void print(String payload){
        logBean.doLog(payload);
    }
}
