package com.lc.spring.db.entity;

import lombok.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liangchao03
 *         2017/10/26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;

    //@DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;
    private Integer yearOfBirth;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime insertTime;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updateTime;

    private List<Book> book;
}
