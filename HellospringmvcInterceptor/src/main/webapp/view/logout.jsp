<%--
  Created by IntelliJ IDEA.
  User: 带ta去蒙古国
  Date: 2021/3/6
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>登出页面</title>
</head>
<body>
	张三登出系统<br/>
	<% session.removeAttribute("username");%>
</body>
</html>
