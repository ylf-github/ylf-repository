<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.Date_Number"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据格式化</title>
</head>
<body>
<center>
<form action="test" method="post">
<table>
<tr>
<td>日期类型：</td>
<td><input name="birthday" id="birthday"></td>
</tr>
<tr>
<td>整数类型：</td>
<td><input name="total" id="total"></td>
</tr>
<tr>
<td>百分数类型：</td>
<td><input name="discount" id="discount"></td>
</tr>
<tr>
<td>货币类型：</td>
<td><input name="money" id="money"></td>
</tr>
<tr>
<td><input type="submit" value="提交"></td>
</tr>
</table>
</form>
</center>
</body>
</html>