<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body>
<form action="/Tuscany/user/loginUp/p" method="post">
    用户名<input name="name" type="text"><br>
    密码<input name="firstPassword" type="password"><br>
    再次确认密码<input name="secondPassword" type="password"><br>
    手机号<input name="phoneNumber" id="phoneNumber" type="number">
    <button id="bt01">发送验证码</button>
    <br>
    验证码<input name="verifyCode" type="number"><br>
    <input type="submit" value="注册">
    <script type="text/javascript">
        var bt01 = document.getElementById("bt01");
        var inputPhoneNumber = document.getElementById("phoneNumber");

        bt01.onclick = function () {
            var phoneNumber = inputPhoneNumber.value;
            alert(phoneNumber);
            vertiCodeSend(phoneNumber);
            bt01.disabled = true;  //当点击后倒计时时候不能点击此按钮
            var time = 5;  //倒计时5秒
            var timer = setInterval(fun1, 1000);  //设置定时器
            function fun1() {

                time--;
                if (time >= 0) {
                    bt01.innerHTML = time + "s后重新发送";
                } else {
                    bt01.innerHTML = "重新发送验证码";
                    bt01.disabled = false;  //倒计时结束能够重新点击发送的按钮
                    clearTimeout(timer);  //清除定时器
                    time = 5;  //设置循环重新开始条件
                }
            }

            function vertiCodeSend(phone) {
                $.ajax({
                    url: "/SpringRMI/user/sendPhoneCode",  //发送验证码的php页面
                    data: {"phone": phone},//传入后台
                    type: "POST",//类型
                });
            }
        }
    </script>
</form>
</body>
</html>