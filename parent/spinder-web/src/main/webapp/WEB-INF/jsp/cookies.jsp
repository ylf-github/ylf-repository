<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookie测试</title>
</head>
<body>
	<%
		Cookie c = new Cookie("name", "张三");
		response.addCookie(c);
	%>
	<a href="http://localhost:8080/spinder-web/cookietest">测试cookie</a>
	<script type="text/javascript">
		/*function setCookie(c_name, value, expiredays) {
			var exdate = new Date()
			exdate.setDate(exdate.getDate() + expiredays)
			document.cookie = c_name
					+ "="
					+ escape(value)
					+ ((expiredays == null) ? "" : ";expires="
							+ exdate.toGMTString())
		}
		function getCookie(c_name) {
			if (document.cookie.length > 0) {
				c_start = document.cookie.indexOf(c_name + "=")
				if (c_start != -1) {
					c_start = c_start + c_name.length + 1
					c_end = document.cookie.indexOf(";", c_start)
					if (c_end == -1)
						c_end = document.cookie.length
					return unescape(document.cookie.substring(c_start, c_end))
				}
			}
			return ""
		}
		setCookie("sex","男",1);
		 */
		          document.cookie="nm=男人;path=/"  
		           document.cookie="age=18;path=/"  
		           // 时间可以不要，但路径(path)必须要填写，因为JS的默认路径是当前页，如果不填，此cookie只在当前页面生效！~
		 

	</script>
</body>
</html>