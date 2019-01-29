<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<form class="" name="login" action="/SpringRMI/user/loginIn" method="post">
    <input name="account" type="text" placeholder="手机号/邮箱"><br>
    <input name="password" type="password" placeholder="请输入登录密码" minlength="6" maxlength="16"><br>
    <input type="submit" value="登录"/>
    <a href="/Tuscany/user/loginUp/p" style="color:#000000">手机注册</a>
    <a href="/Tuscany/user/loginUp/e" style="color:#000000">邮箱注册</a>
</form>
</body>
</html>

