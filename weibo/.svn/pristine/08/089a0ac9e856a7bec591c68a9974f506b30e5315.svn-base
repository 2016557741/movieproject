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

<title>My JSP 'users_init.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jeasyui/jquery-1.8.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jeasyui/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jeasyui/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/jeasyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/jeasyui/themes/default/easyui.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/backstage/users/users_init.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jeasyui/custom-je.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/backstage/users/users_style.css">
</head>

<body class="easyui-layout">
	<div data-options="region:'center'">
		<div id="tb" style="padding:5px;height:auto">
			<div>
				邮箱: <input id="s_email" > 昵称:<input id="s_nikeName"
					style="width: 80px;"> 是否验证:<input
					id="s_status"  style="width: 80px;">
				<a id="s_searchBtn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
			</div>
		</div>
		<table id="dg" data-options="fit:true,toolbar:'#tb'"></table>
	</div>
</body>
</html>
