<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'chooserole.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<div align="middle">
		<h1 style="line-height: 40px">APP信息管理平台</h1>
		<div align="middle" >
			<a href="login/backend" style="text-decoration: none;line-height: 40px;font-size: 20px;color: blue;">后台管理系统入口</a>
		</div>
		<div align="middle">
			<a href="login/dev" style="line-height: 40px;font-size: 20px;text-decoration: none;color: blue;">开发者平台入口</a>
		</div>
	</div>
</body>
</html>
