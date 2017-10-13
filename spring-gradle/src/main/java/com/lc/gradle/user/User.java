package com.lc.gradle.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by liangchao on 17-10-12.
 */
@Data
@NoArgsConstructor
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

    public User(Integer id, String name, String email, String mobile, String realName, String school, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.realName = realName;
        this.school = school;
        this.birthDay = birthDay;
    }
}
