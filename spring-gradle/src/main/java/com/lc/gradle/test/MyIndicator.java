package com.lc.gradle.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by liangchao03 on 2017/6/15.
 */
@Component
public class MyIndicator implements HealthIndicator{
    @Autowired
    private User user;



    @Override
    public Health health() {
        int errorCode = chech();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code",errorCode).build();
        }

        return Health.up().withDetail("Success Code",1).build();
    }

    private int chech() {
        if(user.getAge()>15){
            return 0;
        }
        return 1;
    }
}
