<%--
  Created by IntelliJ IDEA.
  User: yuanhai
  Date: 2020/12/13
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- 引入jquery -->
    <script type="text/javascript" src="js/jquery.min.js"></script>

    <script>

        // 页面加载，给btn绑定点击事件
        $(function () {
            $("#btn").click(function () {
                alert("hello btn");
            });
        });

    </script>

</head>
<body>

    <a href="user/testString">返回值类型为String</a><br>
    ------------------------------------------------------------<br>
    <a href="user/testVoid">返回值类型为void</a><br>
    ------------------------------------------------------------<br>
    <a href="user/testModelAndView">返回值类型为ModelAndView</a><br>
    ------------------------------------------------------------<br>
    <a href="user/testForwardOrRedirect">forward和redirect（转发和重定向）</a><br>

=========================================================================================<br>

    <button id="btn">发送ajax请求</button>


</body>
</html>
