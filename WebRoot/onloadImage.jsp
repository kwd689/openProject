<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'onloadImage.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script  type="text/javascript" src="<%=path%>/javascript/jquery-1.8.3.min.js" > </script>
        <script  type="text/javascript" src="<%=path%>/javascript/onloadImage.js" > </script>
        <script  type="text/javascript" src="<%=path%>/javascript/common.js" > </script>
<style type="text/css">
#large {
	position: absolute;
	display: none;
	z-index: 999;
}
</style>
	</head>
	<body>

		上传预览图片:
		<br>
		<input id="f1" name="f1" type="file" />
		<br>
		<img id="img1" width="120" height="60"
			src="<%=path%>/pic/lighta.jpg" style="height: 172px;width: 172px;">

		<div id="large"></div>

		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		鼠标滑过预览图片:
		<br>
		<img width="120" height="60"
			src="<%=path%>/pic/qs.jpg" style="height: 172px;width: 172px;">
		<br>
		<img width="120" height="60"
			src="<%=path%>/pic/qs2.jpg" style="height: 172px;width: 172px;">
		<br>
	</body>
</html>