package com.yuanhai.controller;

import com.yuanhai.domain.Account;
import com.yuanhai.domain.AccountForCollection;
import com.yuanhai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * @return String
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("saveAccount run...");
        System.out.println(account);
        return "success";
    }

    /**
     * 请求参数绑定:JavaBean中包含List和Map集合
     * @param accountForCollection
     * @return String
     */
    @RequestMapping("/saveAccountContainCollection")
    public String saveAccountContainCollection(AccountForCollection accountForCollection){
        System.out.println("saveAccountContainCollection run...");
        System.out.println(accountForCollection);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return String
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("saveUser run...");
        System.out.println(user);
        return "success";
    }

    /**
     * 测试获取servlet原生的API
     * @return String
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.println("testServletAPI run...");
        System.out.println(request);
        System.out.println(response);
        HttpSession session = request.getSession();
        System.out.println("session--->:"+session);
        System.out.println("ServletContext();--->:"+session.getServletContext());
        return "success";
    }

}
