<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow:hidden;">
	<head>
		<base href="<%=basePath%>">

		<c:if test="${user == null}">
			<script type="text/javascript">
	window.location.href = "./frontstage/login.jsp";
</script>
		</c:if>


		<title>家谱网</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="家谱网">


		<link rel="stylesheet" type="text/css"
			href="./styles/frontstage/index/bootstrap.css">
		<link type="text/css" rel="stylesheet"
			href="./styles/frontstage/index/layout.css">
		<link type="text/css" rel="stylesheet"
			href="./styles/jqueryui/jquery-ui-1.10.3.custom.min.css">
 		<link rel="stylesheet" type="text/css"
			href="./styles/frontstage/userinfo/css.css">
		<link rel="stylesheet" type="text/css"
			href="./styles/frontstage/userinfo/message.css">
		<link rel="stylesheet" type="text/css"
			href="./styles/frontstage/userinfo/userinfo.css">

		<script type="text/javascript"
			src="./scripts/jquery/jquery-1.9.1.min.js"></script>

		<script type="text/javascript"
			src="./scripts/jqueryui/jquery-ui-1.10.3.custom.js"></script>
		<script type="text/javascript"
			src="./scripts/jqueryui/extend/jq-ui-extend.js"></script>
 		<script type="text/javascript"
			src="./scripts/frontstage/common/head.js"></script>
		<script type="text/javascript" src="./scripts/common/dateUtil.js"></script>
        <script type="text/javascript"
			src="${pageContext.request.contextPath }/scripts/jeasyui/jquery.validate.js"></script>

		<script type="text/javascript"
			src="./scripts/frontstage/userinfo/password.js"></script>

 		  <script type='text/javascript' src='/weibo/dwr/engine.js'></script>
 		 <script type='text/javascript' src='/weibo/dwr/interface/UsersService.js'></script>
  		<script type='text/javascript' src='/weibo/dwr/util.js'></script>
 		 




	</head>
	<body data-spy="scroll" data-target=".bs-docs-sidebar"
		data-twttr-rendered="true" screen_capture_injected="true"
		style="overflow: auto;">
		<!-- nav bar -->
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<div class="container">
					<div class="nav-line"></div>
					<a class="brand"
						href="${pageContext.request.contextPath }/index.jsp"><img
							src="./images/index/logo-home.png"> </a>
					<div class="nav-collapse collapse" style="height: 0px;">
						<ul class="nav" id="navbar">
							<li class="padding_34">
								<div class="activearrow"></div>
								<a class="big_title"
									href="./csdn/UsersAction_showIndex.action">首页</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34">
								<div class="activearrow"></div>
								<a class="big_title" href="./frontstage/pedigree.jsp">家族树</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title" href="./csdn/AlbumAction_showAlbum.action">家庭相册</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34">
								<div class="activearrow"></div>
								<a class="big_title"
									href="./csdn/AffairAction_queryAffairList.action">家庭事件</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title"
									href="./csdn/AnniversaryAction_showTimeline.action">纪念日</a>
								<div class="navbar-activeline"></div>
							</li>
						</ul>
						<form id="search" class="form-search"
							style="display: inline-block; margin-top: 24px;"
							onsubmit="return false;">

							<input type="text" style="width: 170px;" class="search-query"
								id="search_friend" placeholder="搜索好友">

						</form>
						<ul class="nav pull-right" style="margin-right: -20px;">
							<li>
								<a class="top_a3" href="javascript:void(0)" id="help">其他</a>
							</li>
							<li>
								<ul class="dropdown-menu mt_20" style="left: -98px"
									id="help_menu">
									<li>
										<a
											href="./csdn/UserinfoAction_showUserinfo.action">账户设置</a>
									</li>
									<li>
										<a id="outUser" href="./csdn/UsersAction_logout.action">退出</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<div class="div2"></div>
			</div>
		</div>
		<!-- content-->

		<div class="container">

			<div class="col2 left">
				<ul class="card info-tab">
					<li>
						<h3>
							设置中心
						</h3>
					</li>
					<li >
						<a
							href="./csdn/UserinfoAction_showUserinfo.action">个人资料</a>
					</li>
					<li>
						<a
							href="./frontstage/head_img.jsp">更改头像</a>
					</li>
					<li class="active">
						<a
							href="./frontstage/password.jsp">修改密码</a>
					</li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li> 
					<li></li>	 		
					<li></li>
					<li></li>
				</ul>

			</div>
			<div class="col8 right">
				<div class="card">
					<form method="POST" id="infoForm"
						 
						class="form-horizontal">
				        <div class="control-group">
							<label class="control-label" for="inputBirthday">
								旧密码
							</label>
							<div class="controls">

								<input     value=""
									id="oldPassword" type="password">

							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputBirthday">
								新密码
							</label>
							<div class="controls">

								<input     value=""
									id="newPassword" type="password">

							</div>
						</div>
			            <div class="control-group">
							<label class="control-label" for="inputBirthday">
								密码确认
							</label>
							<div class="controls">

								<input    value=""
									id="confirmPassword" type="password">

							</div>
						</div>
						<div class="form-actionss">
 							<input  class="btn btn-primary input-xxxlarge"
								value="保存" type="button" id="submitBtn">
						</div>
						<div class="control-group" style="height: 350px">
						</div>

					</form>

				</div>

			</div>
	</body>
</html>