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

<title>My JSP 'pictures_init.jsp' starting page</title>

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
	src="${pageContext.request.contextPath }/scripts/backstage/pictures/pictures_init.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jeasyui/custom-je.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/styles/backstage/pictures/pictures_style.css">
</head>

<body class="easyui-layout">
	<div data-options="region:'center'">
		<div id="tb" style="padding:5px;height:auto">
			<div>
				用户Email<input name="email" id="s_users_email" panelHeight="auto"
					panelWidth="auto"> 微博ID <input name="id" id="s_messages_id"
					panelHeight="auto" style="width: 80px;"> 图片类型<input
					name="type" id="s_type" panelHeight="auto" style="width: 80px;">
				<a id="s_searchBtn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
			</div>
		</div>
		<table id="dg" data-options="fit:true,toolbar:'#tb'"></table>
	</div>

	<div id="uploadimg" style="background-color: #F2F2F2;">
		<form id="ff" enctype="multipart/form-data" method="post">
			<div style="text-align: center; height: 60px;">
				<div style="font-family: 微软雅黑;font-size: 20px;font-weight: bold;">请选择一张图片</div>
				<input type="file" size="30" id="uploadimgurl" name="upload" />
			</div>


			<div id="uploadimgshow" style="margin: 0 auto;text-align: center;">
				<img
					style="color: #333;
	filter: progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);/*ie*/
	-moz-box-shadow: 1px 1px 5px #909090;/*firefox*/
	-webkit-box-shadow: 1px 1px 5px #909090;/*safari或chrome*/
	box-shadow: 1px 1px 5px #909090;/*opera或ie9*/ "
					border="0" alt="图片没有找到，上传后才可预览"
					onload="javascript:DrawImage(this,200,200)" />
			</div>
		</form>

	</div>


</body>
</html>
