package com.fjnu.intelligentwardrobe.Service.impl;

import com.fjnu.intelligentwardrobe.Bean.User;
import com.fjnu.intelligentwardrobe.Mapper.UserMapper;
import com.fjnu.intelligentwardrobe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findUser(Integer phone, String password) {
        return userMapper.findUser(phone,password);
    }

    @Override
    public List<User> findUserByPhone(Integer phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public boolean saveUser(Integer phone, String password) {
        if (userMapper.saveUser(phone,password)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateUser(Integer uid, String column, String value) {
        if (userMapper.updateUser(uid,column,value)>0)
            return true;
        else
            return false;
    }
}
