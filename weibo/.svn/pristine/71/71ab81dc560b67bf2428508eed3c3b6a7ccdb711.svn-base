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

<title>My JSP 'messages_init.jsp' starting page</title>

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
	src="${pageContext.request.contextPath }/scripts/jeasyui/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/jeasyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/jeasyui/themes/default/easyui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jeasyui/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/backstage/messages/messages_init.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jeasyui/custom-je.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/backstage/messages/messages_style.css">
</head>

<body class="easyui-layout">
	<div data-options="region:'center'">
		<div id="tb" style="padding:5px;height:auto">
			<div>
				微博内容:<input id="s_info" style="width: 80px;">
				微博类型:<input id="s_type" style="width: 120px;">
				微博标签:<input id="s_label" panelHeight="auto" style="width: 100px;">
				微博用户:<input id="s_users_email" panelHeight="auto" style="width: 100px;">
				<a id="s_searchBtn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
			</div>
		</div>
		<table id="dg" data-options="fit:true,toolbar:'#tb'"></table>
	</div>
</body>
</html>
