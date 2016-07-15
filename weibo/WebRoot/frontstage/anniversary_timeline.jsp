<%@ page language="java" import="java.util.*,www.csdn.project.domain.Users" pageEncoding="UTF-8"%>
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
	style="overflow:hidden;">
	<head>
		<base href="<%=basePath%>">
	 
		 <c:if test="${user == null}">
			<script type="text/javascript">
				window.location.href = "./frontstage/login.jsp";
			</script>
		</c:if>
        
		<title>家庭圈</title>
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
			href="./styles/timeline/history.css">
	    <link type="text/css" rel="stylesheet"
			href="./styles/jqueryui/jquery-ui-1.10.3.custom.min.css">

		<script type="text/javascript"
		src="./scripts/jquery/jquery-1.9.1.min.js"></script>
		
		<script type="text/javascript"
		src="./scripts/jqueryui/jquery-ui-1.10.3.custom.js"></script>	
		<script type="text/javascript"
		src="./scripts/jqueryui/extend/jq-ui-extend.js"></script>	
		
 		<script type="text/javascript"
			src="./scripts/frontstage/common/head.js"></script>
		<script type="text/javascript"
			src="./scripts/frontstage/anniversary/anniversary.js"></script>
	    <script type="text/javascript" src="./scripts/common/dateUtil.js"></script>
	    
 		<script type="text/javascript"
			src="./scripts/timeline/jquery.mousewheel.js"></script>
		<script type="text/javascript"
			src="./scripts/timeline/jquery.easing.js"></script>
		<script type="text/javascript" src="./scripts/timeline/history.js"></script>
	    <script type="text/javascript"
			src="${pageContext.request.contextPath }/scripts/jeasyui/jquery.validate.js"></script>


		<script type='text/javascript' src='/weibo/dwr/engine.js'></script>
		<script type='text/javascript'
			src='/weibo/dwr/interface/AnniversaryService.js'></script>
		<script type='text/javascript' src='/weibo/dwr/util.js'></script>



		<script type="text/javascript">
            var userInfoId="<%=((Users)session.getAttribute("user")).getId()%>";
            var optionStatus="<%=request.getAttribute("optionStatus") %>";
           
         </script>
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
							<li class="padding_34">
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
							<li class="active padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title" href="./csdn/AnniversaryAction_showTimeline.action">纪念日</a>
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
		<!-- content-->
		<div id="arrow">
			<ul>
				<li class="arrowup"></li>
				<li class="arrowdown"></li>
			</ul>
		</div>
		<div id="history">
			<div class="title">
				<h2>
					家族纪念日
				</h2>
				  <div id="circle">
					<div class="cmsk"></div>
					<div class="circlecontent">
						<div thisyear="2014" class="timeblock">
							<span class="numf"></span>
							<span class="nums"></span>
							<span class="numt"></span>
							<span class="numfo"></span>
							<div class="clear"></div>
						</div>
						<div class="timeyear">
							YEAR
						</div>
					</div>
					<a href="javascript:void(0)" id="newAnniversary" class="clock" title="添加纪念日"></a>
				</div>
			</div>

			<div id="content">
				<ul class="list">
						<s:iterator value="#request.anniversaryList"   id="item">  
		 					<li id="<s:property value="id"/>_li" >
								<div class="liwrap">
									<div class="lileft">
										<div class="date">
											<span class="year"><s:date name="date" format="yyyy" /></span>
											<span class="md"> <s:date name="date" format="MM-dd" /></span>
										</div>
									</div>
									<div class="point">
										<b></b>
									</div>
									<div class="liright">
										<div class="histt">
											<a href="javascript:void(0);" class="dialog_button" anniversaryId="<s:property value="id"/>" userInfoId="<s:property value="userinfoId"/>"><s:property value="name" /></a>
										</div>
										<div class="hisct" style="color: #66CD00;font-size: 16px"><s:property value="userinfo.trueName" /></div>
										<div class="hisct"><s:property value="comment" /></div>
									</div>
								</div>
							</li>
	                 </s:iterator>  
				</ul>
			</div>
		</div>
	
		<div id="dialog-form-edit" title="编辑纪念日">
		  <form id="form-edit" action="${pageContext.request.contextPath }/csdn/AnniversaryAction_modifyAnniversary.action" method="post">
		   <input type="hidden" id="edit_anniversary_id" name="id">
		   <div style="display: block;clear: both;">
				<label id="edit_anniversary_name_Label" for="edit_anniversary_name" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 *纪念日名称
		        </label>
	 			<input id="edit_anniversary_name"  name="name"  type="text" style="width: 220px;float: left;"/>
		   </div>
		   <div style="display: block;clear: both;">
				<label id="edit_anniversary_comment_Label" for="edit_anniversary_comment"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			*纪念日备注
		        </label>
				<textarea id="edit_anniversary_comment"  name="comment"   style="width: 220px; float: left;">
				</textarea>
			</div>
		    <div style="display: block;clear: both;">
				<label id="edit_anniversary_date_Label" for="edit_anniversary_date"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			*纪念日日期
		        </label>
	 			<input id="edit_anniversary_date" type="text"  name="date"   style="width: 220px;float: left;"/>
			</div>
			 <input type="submit" id="editSubmit" style="display: none;">
		  </form>	
		</div>
		<div id="dialog-form-new" title="添加纪念日 ">
		 <form id="form-new" action="${pageContext.request.contextPath }/csdn/AnniversaryAction_createAnniversary.action" method="post">
		   <div style="display: block;clear: both;">
				<label id="new_anniversary_name_Label"  for="new_anniversary_name" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 *纪念日名称
		        </label>
	 			<input id="new_anniversary_name" name="name"  type="text" style="width: 220px;float: left;"/>
	 			
		   </div>
		   <div style="display: block;clear: both;">
				<label id="new_anniversary_comment_Label" for="new_anniversary_comment"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 *纪念日备注
		        </label>
				<textarea id="new_anniversary_comment" name="comment"   style="width: 220px; float: left;"></textarea>
			</div>
		    <div style="display: block;clear: both;">
				<label id="new_anniversary_date_Label" for="new_anniversary_date"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			*纪念日日期
		        </label>
	 			<input id="new_anniversary_date" type="text" name="date" style="width: 220px;float: left;"/>
			</div>
			<input type="submit" id="newSubmit" style="display: none;">
		  </form>	
		</div>
-->


	</body>
</html>