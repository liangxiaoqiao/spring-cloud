package com.lc.gradle.user;

import lombok.Data;
import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by liangchao on 17-10-12.
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private Integer age;
    private Integer sex;
    private String realName;
    private String school;
    private String idCard;

    private LocalDate birthDay;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;

    private String extra1;
    private String extra2;
    private String extra3;

}
