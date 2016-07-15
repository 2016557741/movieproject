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

<title>后台管理页面</title>

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
	src="${pageContext.request.contextPath }/scripts/backstage/index_init.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/backstage/index_style.css">

</head>

<body class="easyui-layout">
	<div data-options="region:'north',split:false"
		style="height:50px;text-align: center;">欢迎<font color="red">${adminsname }</font>登陆后台
		<div style="float: right;margin-top: 30px;"><a href="${pageContext.request.contextPath }/csdn/AdminsAction_exit.action">退出</a></div>
		</div>
	<div data-options="region:'south',split:false"
		style="height:28px;text-align: center;">版权归我们所有</div>
	<div data-options="region:'west',title:'管理列表',split:true"
		style="width:180px;">
		<div id="aa" class="easyui-accordion"
		data-options="fit:true">
			<div title="管理员管理" data-options="selected:true">
				<div class="west_content">
					<a
						href="${pageContext.request.contextPath }/backstage/admins/admins_list.jsp">管理员管理</a>
				</div>
			</div>
			<div title="用户管理">
				<div class="west_content">
					<a
						href="${pageContext.request.contextPath }/backstage/users/users_list.jsp">注册信息</a><br>
					<a
						href="${pageContext.request.contextPath }/backstage/userinfo/userinfo_list.jsp">用户详情</a><br>
					<a
						href="${pageContext.request.contextPath }/backstage/relation/relation_list.jsp">用户关系</a>
				</div>
			</div>

			<div title="微博管理">
				<div class="west_content">
					<a
						href="${pageContext.request.contextPath }/backstage/messages/messages_list.jsp">微博管理</a><br>
					<a
						href="${pageContext.request.contextPath }/backstage/privateletter/privateletter_list.jsp">私信管理</a><br>
					<a
						href="${pageContext.request.contextPath }/backstage/atusers/atusers_list.jsp">@用户管理</a><br>
					<a
						href="${pageContext.request.contextPath }/backstage/collections/collections_list.jsp">收藏管理</a><br>
					<a
						href="${pageContext.request.contextPath }/backstage/comments/comments_list.jsp">评论管理</a>
				</div>
			</div>


			<div title="图片管理">
				<div class="west_content">
					<a
						href="${pageContext.request.contextPath }/backstage/pictures/pictures_list.jsp">图片管理</a>
				</div>
			</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="tt" class="easyui-tabs"  data-options="fit:true">
			<div title="首页" data-options="fit:true">欢迎登陆后台，您可以管理后台数据</div>
		</div>
	</div>
</body>
</html>
