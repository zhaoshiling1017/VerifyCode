<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<form action="<%= path %>/loginServlet" id="loginForm" method="post">
验证码：<input type="text"  name="checkCode"/>
<a href="javascript:nextCode();"><img id="imageCode" alt="" src="<%= basePath %>imageServlet" /></a>
<input type="submit"  name="btn" value="提交" />
</form>
</body>
<script type="text/javascript">
	function nextCode(){
		var stamp = new Date().getTime();
		document.getElementById("imageCode").src = "<%= basePath %>imageServlet?stamp="+stamp;
	}
</script>
</html>