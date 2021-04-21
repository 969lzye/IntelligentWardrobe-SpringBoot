package com.fjnu.intelligentwardrobe.Service;

import com.fjnu.intelligentwardrobe.Bean.User;

import java.util.List;

public interface UserService {
    List<User> findUser(Long phone,String password);
    List<User> findUserByPhone(Long phone);
    boolean saveUser(Long phone,String password);
    boolean updateUser(Integer uid,String column,String value);
}
