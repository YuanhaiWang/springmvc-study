package com.yuanhai.controller;

import com.yuanhai.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定
 * @author yuanhai
 * @date 2020/12/6
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定入门：绑定String类型
     * @param username
     * @param password
     * @return String
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("testParam run...");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "success";
    }

    /**
     * 请求参数绑定:请求参数绑定到JavaBean
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("saveAccount run...");
        System.out.println(account);
        return "success";
    }

}
