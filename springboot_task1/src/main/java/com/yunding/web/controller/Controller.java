package com.yunding.web.controller;

import com.yunding.domain.User;
import com.yunding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/userLogin")
    // 对登录请求判断request的参数值，并存放在map中
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        List<User> users = queryUser();
        session.setAttribute("username",username);
        for(int i=0; i<users.size();i++){
            if(username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())){
                return "index";
            }else {
                if(i==users.size()-1){
                    return "loginError";
                }
            }
        }
        return null;
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUser(){
        List<User> users = userMapper.queryUser();
        System.out.println("查询："+users);
        return users;
    }

    @RequestMapping("/login")
    public String login(User user) {
        if(user!=null){
            userMapper.register(user);
        }
        return "login";
    }
    @RequestMapping("/loginError")
    public String loginError(){
        return "loginError";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }




}
