<%--
  Created by IntelliJ IDEA.
  User: yuanhai
  Date: 2020/12/6
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>

    <%--   请求参数绑定String  --%>
    <a href="param/testParam?username=yuanhai&password=123">请求参数绑定</a>
    <br>

    <%--   请求参数绑定JavaBean  --%>
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br>
        密码：<input type="text" name="password"/><br>
        金额：<input type="text" name="money"/><br>
        用户姓名：<input type="text" name="user.uName"/><br>
        用户年龄：<input type="text" name="user.age"/><br>
        <input type="submit" value="提交"/><br>
    </form>

</body>
</html>
