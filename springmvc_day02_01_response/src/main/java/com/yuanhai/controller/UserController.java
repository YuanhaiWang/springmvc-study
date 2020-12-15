package com.yuanhai.controller;

import com.yuanhai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuanhai
 * @date 2020/12/13
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值类型是String类型，同时返回一个User对象
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString run ...");
        // 模拟从数据库中查询一个User对象，把这个User对象存起来，转发到页面上，从页面上把这个对象的信息取出来
        // 模拟从数据库中查询到User对象
        User user = new User();
        user.setUsername("渊海");
        user.setPassword("123456");
        user.setAge(30);
        // Model对象可以用来存数据
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 返回值类型是void类型
     *      请求转发是一次请求，请求路径不用加上项目名称
     *      重定向是两次请求，请求路径要加上项目名称
     * @param request
     * @param response
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid run ...");
        // 返回值为void情况下，如果想要跳转页面，可以采用以下方法：
        // 一，使用请求转发
        // 编写请求转发的程序，请求转发是一次请求，可以访问到WEN-INF目录下的资源
        // 手动调用请求转发的方法，不会去执行视图解析器，所以要自己提供完整目录
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 二：使用重定向
        // 重定向等于重新发了一次请求，发请求是请求不到WEB-INF目录下的资源的，所以这里重定向到index.jsp去
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        // 三：有可能会直接进行响应
        // 如果想响应中文，需要解决中文乱码
        // 设置乱码转换
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("你好   hello");

        return;
    }


    /**
     * 返回值类型是ModelAndView类型
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView run ...");

        // 创建一个ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 模拟从数据库中查询一个User对象，把这个User对象存起来，转发到页面上，从页面上把这个对象的信息取出来
        // 模拟从数据库中查询到User对象
        User user = new User();
        user.setUsername("wt");
        user.setPassword("123456");
        user.setAge(30);

        // 把user对象存储到modelAndView中，它的底层会把user对象存到request域中
        modelAndView.addObject("user",user);
        // 存入想跳转到的页面 , 这里会走视图解析器
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     *  使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect run ...");

        // 请求转发
//        return "forward:/WEB-INF/pages/success.jsp";

        // 重定向  使用redirect关键字不需要自己手动加项目名
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步ajax请求的响应，响应回去json数据
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax run ...");
        // 客户端发送ajax请求，传的是json字符串
        // 后端已经把json字符串封装到User对象中
        System.out.println(user);

        //　进行响应
        // 模拟查询数据库
        user.setUsername("浮沉");
        user.setPassword("12582");
        user.setAge(25);
        // 做响应
        return user;

    }


}
