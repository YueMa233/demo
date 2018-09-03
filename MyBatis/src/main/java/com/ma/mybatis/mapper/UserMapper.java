package com.ma.mybatis.mapper;

import com.ma.mybatis.pojo.User;
import com.ma.mybatis.pojo.UserCustom;

import java.util.List;

public interface UserMapper {
    public void addUser(User user);
    public User findUserById(Integer id);
    public User findUserByName(String name);
    public List<User> findUsers(UserCustom userCustom);
    public void updateUserName(User user);

}
