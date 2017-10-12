package com.lc.gradle.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by liangchao on 17-10-12.
 */
public interface UserService {

    Optional<User> findById(Integer id);

    Optional<List<User>> findByName(String name);

    Optional<List<User>> findByEmail(String email);

    Optional<List<User>> findByMobile(String mobile);

    Optional<List<User>> findBySchool(String school);

    Optional<List<User>> findByRealName(String realName);

    Optional<List<User>> findByBirthdayBetween(LocalDate start,LocalDate end);

    Optional<List<User>> findByBirthdayBetween(LocalDate start,LocalDate end,boolean containLeft,boolean containRight);

}
