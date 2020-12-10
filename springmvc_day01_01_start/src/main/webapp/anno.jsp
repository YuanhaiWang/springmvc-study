<%--
  Created by IntelliJ IDEA.
  User: yuanhai
  Date: 2020/12/10
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc的常用注解</title>
</head>
<body>

    <a href="anno/testRequestParam?name=yuanhai">RequestParam注解</a>
    <br>
    ------------------------------------------------------------------------------

    <br>
    RequestBody注解：
    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username"/><br>
        用户年龄：<input type="text" name="age"/><br>
        <input type="submit" value="提交"/><br>
    </form>

    ------------------------------------------------------------------------------
    <br>
    <a href="anno/testPathVariable/10">PathVariable注解</a>

    ------------------------------------------------------------------------------
    <br>
    <a href="anno/testRequestHeader">RequestHeader注解</a>


</body>
</html>
