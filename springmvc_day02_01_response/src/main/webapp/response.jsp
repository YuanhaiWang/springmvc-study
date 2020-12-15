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
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写jason格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"渊海","password":"123321","age":"22"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        // 此处的data表示服务器端会响应的json数据
                        alert(data);
                        alert(data.username);
                    }
                });


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
