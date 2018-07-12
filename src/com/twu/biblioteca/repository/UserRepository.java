package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> userList;

    public UserRepository() {
        userList=new ArrayList<>();
        userList.add(new User("111-0001","123456","Alice","123@qq.com","123456789"));
        userList.add(new User("111-0002","123456","Bob","123@qq.com","123456789"));
        userList.add(new User("111-0003","123456","Carl","123@qq.com","123456789"));
        userList.add(new User("111-0004","123456","David","123@qq.com","123456789"));
    }


}
