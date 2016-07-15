 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	style="overflow-y:scroll;overflow-x:hidden;">
	<head>
	    <base  href="<%=basePath%>">
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
	    
	    
	    <link type="text/css" rel="stylesheet"
			href="./styles/qqface/bootstrap.min.css">
		<link type="text/css" rel="stylesheet"
			href="./styles/qqface/reset.css">
		<link type="text/css" rel="stylesheet"
			href="./styles/uploadify/uploadify.css">
	    <link rel="stylesheet" type="text/css"
			href="./styles/frontstage/index/bootstrap.css">
 		<link type="text/css" rel="stylesheet"
			href="./styles/frontstage/index/layout.css">
		<link type="text/css" rel="stylesheet"
			href="./styles/jqueryui/jquery-ui-1.10.3.custom.min.css">
 		<style type="text/css">
		 	    .infoNode p{
				   font-size: 14px;
				   color: red;
				   margin: 0;
				}
				.infoNode div{
				   text-align: right;
				}
 		</style>
		<script type="text/javascript"
		src="./scripts/jquery/jquery-1.9.1.min.js"></script>
		
		<script type="text/javascript"
		src="./scripts/jqueryui/jquery-ui-1.10.3.custom.js"></script>
		
			<script type="text/javascript"
			src="./scripts/jqueryui/extend/jq-ui-extend.js"></script>
		
		<script type="text/javascript"
		src="./scripts/frontstage/index/index.js"></script>
	 
		<script type="text/javascript"
			src="./scripts/frontstage/common/head.js"></script>
		
		<script type="text/javascript"
		src="./scripts/qqface/jquery.qqFace.js"></script>
		
		<script type="text/javascript"
		src="./scripts/uploadify/swfobject.js"></script>
		
		<script type="text/javascript"
		src="./scripts/uploadify/jquery.uploadify.v2.1.0.min.js"></script>
		
		 <script type="text/javascript" src="./scripts/common/dateUtil.js"></script>
		
		
		  <script type='text/javascript' src='/weibo/dwr/engine.js'></script>
  <script type='text/javascript' src='/weibo/dwr/interface/ReviewService.js'></script>
    <script type='text/javascript' src='/weibo/dwr/util.js'></script>
		
		
 
	</head>
	<body data-spy="scroll" data-target=".bs-docs-sidebar"
		data-twttr-rendered="true" screen_capture_injected="true">
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
							<li class="active padding_34">
								<div class="activearrow"></div>
								<a class="big_title"
									href="./csdn/UsersAction_showIndex.action">首页</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title" href="./frontstage/pedigree.jsp">家族树</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title" href="./csdn/AlbumAction_showAlbum.action">家庭相册</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title" href="./csdn/AffairAction_queryAffairList.action">家庭事件</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class=" padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title" href="./csdn/AnniversaryAction_showTimeline.action">纪念日</a>
								<div class="navbar-activeline"></div>
							</li>
						</ul>
						<form id="search" class="form-search"
							style="display: inline-block; margin-top: 24px;"
							onsubmit="return false;">
							<div style="font-size: 16px;color:red;font-weight: bold;line-height: 30px;">
								 会员号：${sessionScope.user.id}
							</div> 
						</form>
						<ul class="nav pull-right" style="margin-right: -20px;">
							<li>
								<a class="top_a3" href="javascript:void(0)" id="help">其他</a>
							</li>
						</ul>
						<ul class="nav pull-right">
							<li class="dropdown">
								<a href="javascript:;" class="dropdown-toggle"
									data-toggle="dropdown" style="padding: 28px 0;"> <i
									class="icon-certificate icon-white"
									style="background-position: -72px -141px; height: 17px; width: 17px;"></i>
									<b style="margin-top: 10px;"></b> </a>
								<ul class="dropdown-menu mt_20" style="left: -98px"
									id="help_menu">
									<li>
										<a
											href="./csdn/UserinfoAction_showUserinfo.action">账户设置</a>
									</li>
									<li>
										<a href="./csdn/UsersAction_logout.action">退出</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<div class="div2"></div>
			</div>
		</div>
		<!-- Header -->
		<header class="jumbotron">
		<div class="container">
		</div>
		</header>
		<div class="container infopage treepage" id="main">
			<div class="row-fluid eud prblbr">
				<div class="span5" id="leftCol">
					<div class="row-fluid avahead">
						<div class="span8 my_logo">
							<a href="javascript:void(0)">
								<c:if test="${sessionScope.headPic == null}">
								 
								</c:if>
								<c:choose>
									<c:when test="${sessionScope.headPic != null}">
								        	<img class="avatar" src="./images/headpic/${sessionScope.headPic.url}" alt="./images/headpic/${sessionScope.headPic.url}" style=" height: 48px;width: 48px;" >
									</c:when>
									<c:otherwise>
										   <c:choose>
											<c:when test="${sessionScope.user.userinfo.sex == 0}">
										        	<img class="avatar" src="./images/headpic/man.jpg" alt="./images/headpic/man.jpg" style=" height: 48px;width: 48px;" >
											</c:when>
											<c:otherwise>
										         	<img class="avatar" src="./images/headpic/woman.jpg" alt="./images/headpic/woman.jpg" style=" height: 48px;width: 48px;" >
											</c:otherwise>
										 </c:choose>
									</c:otherwise>
								 </c:choose>
							</a>
							<a class="prompt"
								href="./frontstage/head_img.jsp">修改头像
							</a>
						</div>
						<div class="span16">
							<p style="margin: 0;">
								<a href="javascript:void(0);"
									class="my_name"><strong class="my_name">${sessionScope.user.userinfo.trueName }</strong>
								</a>
							</p>
							<p style="margin: 0;" class="userlink">
								<a class="my_edit"
									href="./csdn/UserinfoAction_showUserinfo.action">编辑个人资料</a>
							</p>
						</div>
					</div>
			 
				</div>
				 
				<!-- MAIN -->
				<div class="span19 mainCol">
					<div class="row-fluid">
						<div class="span18" style="display: none;">
						<div style="width: 570px;text-align: center;font-size: 18px;color:  rgb(128,128,128);font-family: 微软雅黑; line-height: 40px" >
									<span id="center_title"></span><span id="center_hot">发言请遵守社区公约，<span
										id="center_replace">还可以输入</span><span id="messege_wn" style="color: red">140</span>字
									</span>
								</div>
							<div id="post-publish" class="row-fluid"  >
								
								<div class="span24 textbox" style="width: 580px;">
									<div class="row-fluid">
										<textarea
											onfocus="$(&#39;#post-publish .textbox&#39;).css({&#39;border-color&#39;:&#39;#FFB26C&#39;,&#39;box-shadow&#39;:&#39;inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(255,178,108,.6)&#39;})"
											onblur="$(&#39;#post-publish .textbox&#39;).css({&#39;border-color&#39;:&#39;#b4b4b4&#39;,&#39;box-shadow&#39;:&#39;none&#39;})"
											class="span24" id="newmessage" name="newmessage"
											clappse-target="#publish" placeholder="说些什么..."
											style="margin-bottom: 0; * width: 570px;" rows="3" title="说些什么..."
											></textarea>
									</div>
									<ul class="nav" id="pub-show">
										<li>
											<div class="alert alert-time">
												<button type="button" class="close">
													×
												</button>
												<span id="time-show" class="show"></span>
											</div>
										</li>
										<li>
											<div class="alert alert-map">
												<button type="button" class="close">
													×
												</button>
												<span id="map-show" class="show"></span>
											</div>
										</li>
										<li>
											<div class="alert alert-picture">
												<button type="button" class="close">
													×
												</button>
												<span id="picture-temp-show" class="show"></span>
											</div>
										</li>
									</ul>

									<div class="row-fluid feature_list">
										<div class="span16">
											<a id="facebtn" data-toggle="modal"
												class="pull-left btn btn-pub" data-index="0"><i
												 ></i>表情</a>
											<a id="map_marker" data-toggle="modal"
												class="pull-left btn btn-pub" data-index="1"><i
												class="icon-map-marker"></i>地点</a>
											<a id="atbtn" class="atbtn pull-left btn btn-pub"><i
												class="icon-print"></i>圈人</a>
											 
											<div class="dropdown">
												<a id="photobtn"
													class="dropdown-toggle pull-left btn btn-pub"
													data-toggle="dropdown" data-index="2"> <i
													class="icon-picture"></i>照片 </a>
 											</div>
										</div>
										<div class="span5" style="line-height: 34px;">
											<div class="dropdown nav-list padding-left_0 width_90">
												<a href="javascript:;" id="_privacy" role="button"
													style="padding-top: 0px;"
													class="dropdown-toggle privacy-set" data-toggle="dropdown"
													data-original-title=" " data-value="-6"> <span
													class="hui" style="padding: 0 2px;"> </span><b
													class="caret" style="margin-top: 16px;display: none"></b> </a>
 											</div>
										</div>
										<div class="span3">
											<button
												style="margin-right: 4px; width: 68px; height: 26px; margin-top: 4px; padding-top: 2px;"
												id="pubbtn" class="btn btn-primary pull-right">
												<strong>发布</strong>
											</button>
										</div>
										 
									</div>
								</div>
							</div>
 
							<div id="common-post">
								<div class="row-fluid">
								 
									<div id="loadnone" class="span24 box hide"
										style="background-color: rgb(238, 238, 238); margin-left: 0px; display: block;">
										<p
											style="text-align: center; font-size: 14px; color: #888888; height: 40px; line-height: 40px;">
											 敬请期待
										</p>
									</div>
									 
								</div>
							</div>
						</div>
						<!-- right add friends -->
						<div class="span6 margin-top_15 rightCol" id="recommend">
						 
							<div class="row-fluid">
								<ul class="nav nav-list">
									<li class="nav-header nh_color">
										 家族成员 
									</li>
								</ul>
							</div>
   							<div id="friend-list">
								<ul class="nav">
   								<s:iterator value="#request.familiyMember"   id="item">  
 									<li>
										<div class="row-fluid friendbox">
											<div style="width: 48px;" class="pull-left">
												<a href="javascript:void(0)">
												
												<s:if test='headPic!=null'>
															<img class="avatar" src="./images/headpic/<s:property value="headPic" />">
											    </s:if> 
											    <s:else>
  													<s:if test='sex==0'>
 													   <img class="avatar" src="./images/headpic/man.jpg" />
									                </s:if> <s:else>
									                   <img class="avatar" src="./images/headpic/woman.jpg" />
									                </s:else> 
												</s:else> 
												
												
												</a>
											</div>
											<div style="width: 130px;" class="pull-right">
												<a class="friendname" title="<s:property value="trueName" />"
													href="javascript:void(0)"><s:property value="trueName" /></a> 
												<small
													style="width: 90px; display: inline-block; overflow: hidden; font-size: 12px; color: #aaaaaa;"><s:property value="comment" /></small>
											</div>
											<div class="btnbox"></div>
											<div class="addbbtn">
												<i class="icon-text-height icon-white"></i>
											</div>
										</div>
									</li>
									 </s:iterator>  
 								</ul>
							</div>
						 
						</div>
					</div>
				</div>
			 
 
				 
				<div id="dialog-form" title="上传 图片 " style="width: 400px;height: 400px;display: none;">
					  <table>  
				        <tr>  
				            <td class="title">图片文件<span class="ff0000"> *</span></td>  
				            <td colspan="3">  
				                <input type="file" name="file" id="file" />  
				                <div id="fileQueue"></div>  
				                <p>  
				                    <a href="javascript:;" onClick="javascript:uploadifyUpload()">开始上传</a>&nbsp;  
				                    <a href="javascript:jQuery('#file').uploadifyClearQueue()">取消所有上传</a>  
				                </p>  
				                <ol class=files></ol>  
				            </td>  
				        </tr>  
				    </table>    
				</div>
			   <div id="dialog-info" title="通知 " style="width: 400px;height: 400px;display: none;">
               </div> 
            </div>
     </div>
 
	</body>
</html>