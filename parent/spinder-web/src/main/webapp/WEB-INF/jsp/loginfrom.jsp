<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
          <center>
          账号：<input id="username"><br>
          密码：<input type="password" id="userpassword"><br>
          <button id="button">登录</button>
          </center>
          <script type="text/javascript">
          var a=$('#username')[0];
          var b=$('#userpassword')[0];
          $('button').on('click', function () {
        	  $.ajax({
					type : 'POST',
					url : "http://localhost:8080/spinder-web/login",
					contentType : "application/json",
					data : JSON.stringify({loginName:a.value,userPassword:b.value}),
					success : function(data){
                           if(data.msg=="ok")
                        	   alert("添加成功!");
                           else
                        	   alert("添加失败!");
             
					}
          });
        	  });
        	 
          </script>
</body>
</html>