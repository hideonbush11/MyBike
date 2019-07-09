package com.project.controller;

import com.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/genCode")
    @ResponseBody
    public boolean genVerifyCode(String countryCode, String phoneNum) {
        userService.sendMsg(countryCode, phoneNum);
        return false;
    }

    @RequestMapping("/user/verify")
    @ResponseBody
    public boolean verify(String phoneNum, String verifyCode) {
        // 调用Service层，进行校验
        return userService.verify(phoneNum, verifyCode);
    }

    @RequestMapping("/user/register")
    @ResponseBody
    public boolean reg(@RequestBody User user) {
        boolean flag = true;
        // 调用service,将用户的数据保存起来
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping("/user/deposit")
    @ResponseBody
    public boolean deposit(@RequestBody User user) {
        boolean flag = true;
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @RequestMapping("user/identify")
    @ResponseBody
    public boolean identify(@RequestBody User user) {
        boolean flag = true;
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
