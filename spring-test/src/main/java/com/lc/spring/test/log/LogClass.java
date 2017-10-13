package com.lc.spring.test.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liangchao03
 *         2017/10/13
 */
public class LogClass {
    private static final Logger log = LoggerFactory.getLogger(LogClass.class);

    public static void main(String[] args) {
        log.error("This is a slf4j log  {}", "bind param");
        log.error("Log Class:{}",log.getClass());
    }
}
