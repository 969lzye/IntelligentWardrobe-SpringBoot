package com.fjnu.intelligentwardrobe.Mapper;

import com.fjnu.intelligentwardrobe.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findUser(Long phone,String password);
    List<User> findUserByPhone(Long phone);
    Integer saveUser(Long phone,String password);
    Integer updateUser(Integer uid,String column,String value);
}
