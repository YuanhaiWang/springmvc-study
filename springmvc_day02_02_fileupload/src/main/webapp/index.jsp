<%--
  Created by IntelliJ IDEA.
  User: yuanhai
  Date: 2020/12/16
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>


    <h3>文件上传</h3>
    -------------------------------------------------<br>
    <h3>传统方式文件上传</h3>
    <form action="fileUpload/fileUpload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /> <br>
        <input type="submit" value="上传">
    </form>

    -------------------------------------------------<br>

    <h3>springmvc方式文件上传</h3>
    <form action="fileUpload/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /> <br>
        <input type="submit" value="上传">
    </form>

</body>
</html>
