<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <p>第一个SpringMVC页面</p>
    <p><a href="user/some.do">发起some.do请求</a></p><br/>
    <form action="user/receive1.do" method="post">
        <input type="text" name="username">
        <input type="text" name="age">
        <input type="submit" value="提交">
    </form>

    <p>解决请求参数名和形参名不一致问题</p>
    <form action="user/receive2.do" method="post">
        <input type="text" name="rusername">
        <input type="text" name="rage">
        <input type="submit" value="提交">
    </form>

    <p>对象接收参数</p>
    <form action="user/receive3.do" method="post">
        <input type="text" name="username"><br>
        <input type="text" name="age"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
