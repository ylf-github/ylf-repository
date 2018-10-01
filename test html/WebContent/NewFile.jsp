<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>123</nav>
<input type="date">
<progress id="pro" min="0" max="100"></progress>
<meter id="pro2" low="40" min="0" max="100"  optimun="80"></meter>
<details>
<summary>想看美女</summary>
这是测试用的</details>
<br>
<section>789</section>
<input type="range">
<footer>567</footer>789
<script type="text/javascript">
var obj=document.getElementById("pro");
  setInterval(function(){
	  if(obj.value<100)
		  obj.value=obj.value+1;
  },100);
  var obj2=document.getElementById("pro2");
  setInterval(function(){
	  if(obj2.value<100)
		  obj2.value=obj2.value+1;
  },100);
  
</script>
</body>
</html>