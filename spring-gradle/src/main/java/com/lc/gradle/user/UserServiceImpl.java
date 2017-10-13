package com.lc.gradle.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by liangchao on 17-10-12.
 */
@Service
public class UserServiceImpl implements UserService{
    private static List<User> users;

    static{
        users = new ArrayList<>(10);
        LocalDate now =LocalDate.now();
        User user1 = new User(1,"A","aaa@qq.com","10000000001","姓名1","清华大学",now);
        User user2 = new User(2,"B","bbb@qq.com","10000000002","姓名2","北京大学",now.plusDays(3));
        User user3 = new User(3,"C","ccc@qq.com","10000000003","姓名3","上海大学",now.plusDays(30));
        User user4 = new User(4,"D","ddd@qq.com","10000000004","姓名4","山东大学",now.plusDays(12));
        User user5 = new User(5,"E","eee@qq.com","10000000005","姓名5","吉林大学",now.plusDays(5));
        User user6 = new User(6,"F","fff@qq.com","10000000006","姓名6","蒙古大学",now.plusDays(7));
        User user7 = new User(7,"C","ccc@qq.com","10000000007","姓名7","河南大学",now.plusDays(9));
        User user8 = new User(8,"A","aaa@qq.com","10000000008","姓名8","清华大学",now.plusDays(10));
        User user9 = new User(9,"B","bbb@qq.com","10000000009","姓名9","北京大学",now.plusDays(1));
        User user10 = new User(10,"B","bbb@qq.com","10000000010","姓名10","淘宝大学",now);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);

    }

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream().filter(user -> user.getId().intValue() == id.intValue()).findFirst();
    }

    @Override
    public Optional<List<User>> findByName(String name) {
        List<User> list = users.stream().filter(user -> user.getName().contains(name)).collect(Collectors.toList());
        return convert(list);
    }

    @Override
    public Optional<List<User>> findByEmail(String email) {
        List<User> list = users.stream().filter(user -> user.getEmail().contains(email)).collect(Collectors.toList());
        return convert(list);
    }

    @Override
    public Optional<List<User>> findByMobile(String mobile) {
        List<User> list = users.stream().filter(user -> user.getMobile().equals(mobile)).collect(Collectors.toList());
        return convert(list);
    }

    @Override
    public Optional<List<User>> findBySchool(String school) {
        List<User> list = users.stream().filter(user -> user.getSchool().equals(school)).collect(Collectors.toList());
        return convert(list);
    }

    @Override
    public Optional<List<User>> findByRealName(String realName) {
        List<User> list = users.stream().filter(user -> user.getRealName().equals(realName)).collect(Collectors.toList());
        return convert(list);
    }

    @Override
    public Optional<List<User>> findByBirthdayBetween(LocalDate start, LocalDate end) {
        List<User> list = users.stream().filter(user -> {
            LocalDate birth = user.getBirthDay();
            return birth.isEqual(start)||birth.isEqual(end)||(birth.isAfter(start) && birth.isBefore(end));
        }).collect(Collectors.toList());
        return convert(list);
    }

    @Override
    public Optional<List<User>> findByBirthdayBetween(LocalDate start, LocalDate end, boolean containLeft, boolean containRight) {
        if(containLeft && containRight){
            return findByBirthdayBetween(start,end);
        }

        List<User> list = users.stream().filter(user -> {
            LocalDate birth = user.getBirthDay();
            if(!containLeft && !containRight){
                return birth.isAfter(start) && birth.isBefore(end);
            }else if(containLeft){
                return birth.isEqual(start) || (birth.isAfter(start) && birth.isBefore(end));
            }else{
                return birth.isEqual(end) || (birth.isAfter(start) && birth.isBefore(end));
            }

        }).collect(Collectors.toList());
        return convert(list);
    }

    private Optional<List<User>> convert(List<User> list){
        return list==null||list.size()==0? Optional.empty():Optional.of(list);
    }
}
