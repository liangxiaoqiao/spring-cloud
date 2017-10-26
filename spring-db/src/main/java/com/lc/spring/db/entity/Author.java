package com.lc.spring.db.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author liangchao03
 *         2017/10/26
 */
@Data
@Builder
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer yearOfBirth;
    private LocalDateTime insertTime;
}
