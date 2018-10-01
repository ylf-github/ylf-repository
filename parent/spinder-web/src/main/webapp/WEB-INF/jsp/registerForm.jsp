<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
         <center>
         <h3>注册页面</h3>
         <form action="register" method="post">
         <table>
           <tr>
           <td><label>登录名：</label></td>
           <td><input type="text" id="loginname" name="loginname"></td>
           </tr>
           <tr>
           <td><label>生日：</label></td>
           <td><input type="text" id="birthday" name="birthday"></td>
           </tr>
           <tr>
           <td><input type="submit" id="sumbit" value="登录"></td>
           </tr>
         </table>
         </form>
         </center>
</body>
</html>