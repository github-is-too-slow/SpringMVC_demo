<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="static/js/jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $("#ajax").click(function () {
                $.ajax({
                    url: "user/objectajaxArray.do",
                    data: {
                        username: "张三",
                        age: 20
                    },
                    type: "post",
                    dataType: "json",
                    success: function (objs) {
                        $.each(objs, function (i, obj) {
	                        alert(obj.username + " = " + obj.age);
                        })
                    }
                });
            });

            $("#ajax2").click(function () {
                $.ajax({
                    url: "user/objectajaxString.do",
                    data: {
                        username: "张三",
                        age: 20
                    },
                    type: "post",
                    dataType: "text",
                    success: function (msg) {
                        alert(msg);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <p>返回值是String</p>
    <form action="user/return1.do" method="post">
        <input type="text" name="username">
        <input type="text" name="age">
        <input type="submit" value="提交">
    </form>

    <p>返回值是String</p>
    <form action="user/return2.do" method="post">
        <input type="text" name="username">
        <input type="text" name="age">
        <input type="submit" value="提交">
    </form>

    <%--发起Ajax请求--%>
    <button id="ajax">提交Ajax请求</button><br/>
    <button id="ajax2">提交Ajax请求2</button>
</body>
</html>
