<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>家庭圈</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta name="description=" content="家谱网">

		<link rel="stylesheet" type="text/css"
			href="./styles/frontstage/login/bootstrap.css">
		<link rel="stylesheet" type="text/css"
			href="./styles/frontstage/login/index.css">
	    <style type="text/css">
			#utsdiv {
				float: left;
				width: 216px;
				height: 38px;
				margin-top: -38px;
				margin-left: 38px;
				background-image: url("./images/cloinfo.png"); 
				background-position: 0px 0px;
		    	display:none;
				z-index: 2;
			}
			 
			 .server-error {
 			    top: -20px;
 			}
		</style>		
			

		<script type="text/javascript"
			src="./scripts/jquery/jquery-1.9.1.min.js"></script>
		<script type="text/javascript"
			src="./scripts/frontstage/login/login.js"></script>
			
			
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/scripts/jeasyui/jquery.validate.js"></script>
		<script type="text/javascript"
	 		src="./scripts/frontstage/register/register_init.js"></script>
	  
		
	</head>
	<body>
		<div class="index-header">
			<div class="container">
				<dir>
					<dir></dir>
				</dir>
				<div class="row-fluid" style="margin-top: 10px;">
					<div class="span6">
						<a href="javascript:void(0)"><img class="logo"
								src="./images/login/"> </a>
					</div>
					<div class="span12">
						<h2 class="text-center font-face">
							<a>记录家族历史</a>
						</h2>
					</div>

				</div>
			</div>
			<div style="border-bottom: dotted 1px #FFD87F; margin-top: -12px;"></div>
		</div>
		<div id="page-outer">
			<div class="front-container">
				<div class="front-bg">
			 
				</div>
				<div class="container front-center">
					<div class="row-fluid wellcome">
						<div class="span15">
							<p class="title" style="text-align: center;">
								开始家族的旅程
							</p>
							<hr class="wee">
							<img class="app" src="./images/login/family.jpg"  >
							 
						</div>
						<div class="span7">
							<div class="row-fluid">
								<div class="front-signin">
								    <div id="utsdiv" ></div>
									<form id="login-form" class="form-horizontal"  action="./csdn/UsersAction_login.action" method="post" onsubmit="return checkLogin()">
										<div class="row-fluid"> 
    										<c:if test="${requestScope.loginErrorMap!=null}">
												<p id="loginerror" style="display: block;" >
													<span class="text-error">登录失败,请检查用户名密码是否正确</span>.
												</p>
										 	</c:if>
										</div>
										<div class="placeholding-input">
											<input style="width: 255px;" type="text"  name="email" value="${requestScope.loginErrorMap.email}"
											  id="signin-username" 
											  tabindex="1">
											<label for="signin-username" class="placeholder"
												style="display: block;">电子邮箱</label>
										</div>
										<div class="placeholding-input">
											<input style="width: 255px;" type="password" name="password" value="${requestScope.loginErrorMap.pass}"
												id="signin-password" 
												tabindex="2">
											<label for="signin-password" class="placeholder">密码 </label>
										</div>
										<div class="remember-forgot">
											<label class="remember">
												<input type="checkbox" id="remember_me" value="1"
													name="LoginForm[rememberMe]" tabindex="3">
												<span>&nbsp;记住我</span>
											</label>
											<span class="separator">·</span>
											<a class="forgot" href="${pageContext.request.contextPath }/frontstage/register.jsp">忘记密码?</a>
											<button type="submit" class="btn btn-primary pull-right" tabindex="4"
												style=" *position: absolute; * right: 0;">
												登录
											</button>

										</div>
									</form>
								</div>
							</div>
							<div class="row-fluid">
								<div class="front-reg">
									<h2 class="first">
										第一次来家谱网?
										<span class="muted">免费注册</span>
									</h2>
									<form id="register-form" class="form-horizontal"  action="${pageContext.request.contextPath }/csdn/UsersAction_saveregister.action" method="post" >
										<div class="row-fluid">
											<c:if test="${flag==false }">
												<p id="registererror">
													<span class="text-error">注册失败</span>.
												</p>
											</c:if>
											<c:if test="${flag==true }">
												<p id="registersuccess">
													<span class="text-error">注册成功</span>.
												</p>
											</c:if>
										</div>
										<div class="placeholding-input truename">
											<input style="width: 255px;" class="input_right" type="text"  name="trueName"
												id="reg-truename"  
												autocomplete="off" tabindex="5">
											<label for="reg-truename" class="placeholder">真实姓名</label>
											<div id="truenameerror" class="server-error span24 hide">
												
											</div>
										</div>

										<div class="male-female">
											<label class="sexgroup">
												<input type="radio" value="0" name="sex" tabindex="6" checked="checked">
												<span>男</span>
											</label>
											<label style="margin-left: 10px;" class="sexgroup">
												<input type="radio" value="1" name="sex" tabindex="7">
												<span>女</span>
											</label>
											<span class="sex-error"><span class="arrow_box">请选择性别</span>
											</span>
										</div>

										<div class="placeholding-input reg-username">
											<input style="width: 255px;" type="text" id="reg-username"  name="email"
												autocomplete="off" tabindex="8">
											<label for="reg-username" class="placeholder">电子邮箱</label>
											<div id="accounterror" class="server-error span24 hide">
												
											</div>
										</div>

										<div class="placeholding-input pw">
											<input style="width: 255px;" type="password"  name="password"
												id="reg-password" 
												autocomplete="off" tabindex="9">
											<label for="reg-password" class="placeholder">密码(6-16位字符)</label>
											<div id="pwerror" class="server-error span24 hide">
												
											</div>
										</div>

										 
										
										<div class="placeholding-input reg-username">
											<input style="width: 145px;" type="text" id="reg-checkimg"  name="checkimg"
												autocomplete="off" tabindex="10">
											<label for="reg-checkimg" class="placeholder" style="width: 145px">
												 验证码
											</label>
											 <div id="checkimgerror" class="server-error span24 hide">
												
											</div>
											 <img id="img" title="换一张"
											 src="${pageContext.request.contextPath }/csdn/ImageCheck_execute.action?time=new Date().getTime()"
											  onclick="change(this)" style="float:right;display: block;width:100px;height:28px;cursor: pointer;" name="image" />
											 
 											
										</div>
										
										
										<div class="agree-reg">
											<span class="protocol"> <a target="_blank"
												href="javascript:void(0)"> </a> </span>
											<button type="submit" class="btn btn-info pull-right"  tabindex="11"
												style=" *position: absolute; * right: 0;">
												注册
											</button>
										</div>
										
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div style="clear: both"></div>
				<div class="footer">
					<hr class="wee">
					<div class="container">

					</div>
				</div>
			</div>
		</div>

	</body>
</html>