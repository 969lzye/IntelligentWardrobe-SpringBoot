package com.fjnu.intelligentwardrobe.Service;

import com.fjnu.intelligentwardrobe.Bean.User;

import java.util.List;

public interface UserService {
    List<User> findUser(Integer phone,String password);
    List<User> findUserByPhone(Integer phone);
    boolean saveUser(Integer phone,String password);
    boolean updateUser(Integer uid,String column,String value);
}
