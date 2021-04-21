package com.fjnu.intelligentwardrobe.Controller;

import com.fjnu.intelligentwardrobe.Bean.User;
import com.fjnu.intelligentwardrobe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;



    @RequestMapping("/login")
    public List<User> findUser(String phone,String password){
        System.out.println("小程序前端调用登录，参数："+phone+","+password);
        return userService.findUser(Long.parseLong(phone),password);
    }

    @RequestMapping("/register")
    public boolean register(String phone,String password){
        System.out.println("小程序进行注册，参数："+phone+","+password);
        return userService.saveUser(Long.parseLong(phone),password);
    }

    @RequestMapping("/updateUser")
    public boolean updateUser(String uid,String column,String value){
        System.out.println("小程序前端更新用户信息，参数"+uid+","+column+","+value);
        return userService.updateUser(Integer.parseInt(uid),column,value);
    }

    @RequestMapping("/findUserByPhone")
    public List<User> findUser(String phone){
        System.out.println("小程序前端根据phone返回用户信息，参数："+phone);
        return userService.findUserByPhone(Long.parseLong(phone));
    }
}
