package com.lc.gradle.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by liangchao on 17-10-12.
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public Optional<User> findById(Integer id) {
        return null;
    }

    @Override
    public Optional<List<User>> findByName(String name) {
        return null;
    }

    @Override
    public Optional<List<User>> findByEmail(String email) {
        return null;
    }

    @Override
    public Optional<List<User>> findByMobile(String mobile) {
        return null;
    }

    @Override
    public Optional<List<User>> findBySchool(String school) {
        return null;
    }

    @Override
    public Optional<List<User>> findByRealName(String realName) {
        return null;
    }

    @Override
    public Optional<List<User>> findByBirthdayBetween(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public Optional<List<User>> findByBirthdayBetween(LocalDate start, LocalDate end, boolean containLeft, boolean containRight) {
        return null;
    }
}
