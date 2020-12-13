package com.yuanhai.controller;

import com.yuanhai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * @author yuanhai
 * @date 2020/12/10
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})    // 把msg=渊海存入到Session域对象中一份
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

    /**
     * 获取cookie的值：CookieValue注解
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("testCookieValue run...");
        System.out.println("cookieValue:"+cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @param user
     * @return String
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user){
        System.out.println("testModelAttribute run...");
        System.out.println("user；"+user);
        return "success";
    }

    /**
     * ModelAttribute注解
     *      该注解是 SpringMVC4.3 版本以后新加入的。它可以用于修饰方法和参数。
     *      出现在方法上，表示当前方法会在控制器的方法执行之前，先执行。它可以修饰没有返回值的方法，也可
     * 以修饰有具体返回值的方法。
     *      出现在参数上，获取指定的数据给参数赋值。
     *
     * 应用场景：
     *      当表单提交数据不是完整的实体类数据时，保证没有提交数据的字段使用数据库对象原来的数据。
     * 例如：
     *      我们在编辑一个用户时，用户有一个创建信息字段，该字段的值是不允许被修改的。在提交表单数
     * 据是肯定没有此字段的内容，一旦更新会把该字段内容置为 null，此时就可以使用此注解解决问题。
     */
    // ModelAttribute有返回值的写法
//    @ModelAttribute
//    public User showUser(String uName){
//        System.out.println("showUser run...");
//        // 模拟查询数据库
//        User user = new User();
//        user.setuName(uName);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }

    // ModelAttribute 没有返回值的写法
    @ModelAttribute
    public void showUser(String uName, Map<String,User> map){
        System.out.println("showUser run...");
        // 模拟查询数据库
        User user = new User();
        user.setuName(uName);
        user.setAge(20);
        user.setDate(new Date());

        map.put("abc",user);
    }

    /**
     * SessionAttributes注解
     *      SessionAttributes只能作用在类上
     * @param model
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes run...");
        //  底层会存储到request域对象中
        model.addAttribute("msg","渊海");
        // 存储之后，在跳转到的success.jsp中，使用${ requestScope }可以取得
        return "success";
    }

    /**
     * 在方法中  获取  由SessionAttributes注解存入session域中的值
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes run...");
        // 从session域中取值
        String msg = (String) modelMap.get("msg");
        System.out.println("getSessionAttributes msg:"+msg);
        return "success";
    }

    /**
     * 在方法中  删除  由SessionAttributes注解存入session域中的值
     * @param status
     * @return
     */
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes run...");
        // 从session域中删除
        status.setComplete();
        return "success";
    }

}
