package com.yuanhai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuanhai
 * @date 2020/12/10
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {

    /**
     * RequestParam注解
     * @param username
     * @return String
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("testRequestParam run...");
        System.out.println("username:"+username);
        return "success";
    }

    /**
     * 获取到请求体的内容：RequestBody注解
     * @param requestBody
     * @return String
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("testRequestBody run...");
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return String
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("testPathVariable run...");
        System.out.println("sid:"+id);
        return "success";
    }

    /**
     * 获取请求头信息：RequestHeader注解
     * @param requestHeader
     * @return String
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String requestHeader){
        System.out.println("testRequestHeader run...");
        System.out.println("requestHeader:"+requestHeader);
        return "success";
    }




}
