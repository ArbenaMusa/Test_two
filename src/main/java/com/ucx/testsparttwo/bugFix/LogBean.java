package com.ucx.testsparttwo.bugFix;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class LogBean {
    public void doLog(String object){
        log.debug(object);
    }
}
