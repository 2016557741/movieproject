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
	style="overflow:hidden;">
	<head>
		<base href="<%=basePath%>">
	 <!-- 
		 <c:if test="${user == null}">
			<script type="text/javascript">
				window.location.href = "./frontstage/login.jsp";
			</script>
		</c:if>
	  -->
        
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
        <link rel="stylesheet" type="text/css" 
         	href="./styles/3DGallery/gallery.css" />
        <link rel="stylesheet" type="text/css" 
        	href="./styles/3DGallery/style.css" />
        <link type="text/css" rel="stylesheet"
			href="./styles/jqueryui/jquery-ui-1.10.3.custom.min.css">
			
		<STYLE type="text/css">
		.newAP{
			background: -moz-linear-gradient(center top , #66CD00 0%, #66CD00 100%) repeat scroll 0 0 rgba(0, 0, 0, 0);
		    border: 1px solid #719C7F;
		    border-radius: 5px;
		    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
		    color: #FFFFFF;
		    display: inline-block;
		    font-size: 13px;
		    font-weight: 800;
		    line-height: 18px;
		    margin: 0 3px;
		    padding: 4px 10px 3px;
		    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.9);
		    text-decoration: none;
		    text-align: center;
		    font-family: Cambria,Palatino,"Palatino Linotype","Palatino LT STD",Georgia,serif;
		}
		
		.dg-wrapper a img {
		   width: 482px;
		   height: 316px;
		}
		</STYLE>	
			
  		<script type="text/javascript"
			src="./scripts/jquery/jquery-1.9.1.min.js"></script>
			
		<script type="text/javascript"
		    src="./scripts/jqueryui/jquery-ui-1.10.3.custom.js"></script>	
		<script type="text/javascript"
		    src="./scripts/jqueryui/extend/jq-ui-extend.js"></script>		

		<script type="text/javascript"
			src="./scripts/frontstage/common/head.js"></script>
	    <script type="text/javascript"
			src="./scripts/common/dateUtil.js"></script>
		
		<script type="text/javascript" 
			src="./scripts/3DGallery/modernizr.custom.53451.js"></script>
		<script type="text/javascript" 
 		    src="./scripts/3DGallery/jquery.gallery.js"></script>
 		
 		<script type="text/javascript" src="./scripts/jqform/jquery.form.js"></script>
 		
 		 <script type='text/javascript' src='/weibo/dwr/engine.js'></script>
         <script type='text/javascript' src='/weibo/dwr/interface/PicturesService.js'></script>
         <script type='text/javascript' src='/weibo/dwr/interface/AlbumService.js'></script>
 		 <script type='text/javascript' src='/weibo/dwr/util.js'></script>
 		    
		 
		<script type="text/javascript" 
 		     src="./scripts/frontstage/gallery/gallery.js"></script>
 		 
 	 
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
							<li class="active padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title" href="./csdn/AlbumAction_showAlbum.action">家庭相册</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34 ">
								<div class="activearrow"></div>
								<a class="big_title"href="./csdn/AffairAction_queryAffairList.action">家庭事件</a>
								<div class="navbar-activeline"></div>
							</li>
							<li class="padding_34 ">
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
		 
	   <div class="container">
			<!-- Codrops top bar -->
 			<header style="margin-bottom: 0px;">
				<h1>相册 <span>相册</span></h1>
			  	<nav class="codrops-demos">
				   <s:iterator value="#request.albumList"   id="album"  status="status">  
 						    <s:if test="%{#status.index==0}">
 						    	 <a href="javascript:void(0)" class="current-demo" albumId="<s:property value="#album.id"/>"  title="<s:property value="#album.comment"/>&#10;创建人:<s:property value="#album.userinfo.trueName"/>&#10;创建日期:<s:date name="#album.createDate" format="yyyy-MM-dd" />" ><s:property value="#album.name"/></a>
  						    </s:if>
						    <s:else>
 						    	 <a href="javascript:void(0)" albumId="<s:property value="#album.id"/>"   title="<s:property value="#album.comment"/>&#10;创建人:<s:property value="#album.userinfo.trueName"/>&#10;创建日期:<s:date name="#album.createDate" format="yyyy-MM-dd" />"  ><s:property value="#album.name"/></a>
 						    </s:else>
					</s:iterator>  
				</nav>
			</header>
			<header style="margin-bottom: 30px; padding: 30px 0px 0px;">
			    <a  class="newAP" id="newAlbumButton" href="javascript:void(0)">添加相册</a>
			    <a  class="newAP" id="uploadPictureButton" href="javascript:void(0)">上传照片</a>
 			</header>
			<section id="dg-container" class="dg-container">
				<div class="dg-wrapper">
					 
 				</div>
				<nav>	
					<span class="dg-prev">&lt;</span>
					<span class="dg-next">&gt;</span>
				</nav>
			</section>
        </div>
        -->
 		 <!-- 弹出层 -->
         <div id="editAlbumDialog" title="编辑相册">
 		       <input type="hidden" id="editAlbumId"  >
			   <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumName" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *相册名称
			        </label>
		 			<input id="editAlbumName"     type="text" style="width: 220px;float: left;"/>
			   </div>
			   <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumComment" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *相册备注
			        </label>
 		 			<textarea id="editAlbumComment"     style="width: 230px; float: left;">
				    </textarea>
			   </div>
			    <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumName" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *创建人员
			        </label>
		 			<input id="editAlbumCreateName"   disabled="disabled"  type="text" style="width: 220px;float: left;"/>
			   </div>
			    <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumName" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *创建时间
			        </label>
		 			<input id="editAlbumCreateDate"    disabled="disabled"   type="text" style="width: 220px;float: left;"/>
			   </div>
  		</div>
  		
  		 <div id="newAlbumDialog" title="添加相册">
 			   <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumName" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *相册名称
			        </label>
		 			<input id="newAlbumName"     type="text" style="width: 220px;float: left;"/>
			   </div>
			   <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumComment" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *相册备注
			        </label>
 		 			<textarea id="newAlbumComment"     style="width: 230px; float: left;"></textarea>
			   </div>
   		</div>

  		 <div id="uploadPictureDialog" title="上传照片">
  		      <form id="uploadForm" method="post" enctype="multipart/form-data"> 
  		      <input type="hidden" name='albumId' id='newPicAlbumId' value="">
 			   <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumName" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *照片备注
			        </label>
		 			<input id="newPicComment"   name='comment'  type="text" style="width: 220px;float: left;"/>
			   </div>
			   <div style="display: block;clear: both;">
					<label id="edit_anniversary_name_Label" for="editAlbumComment" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *选择图片
			        </label>
			        <input id="fileupload" name="fileupload" type="file"    style="float: left;"/>  
 			   </div>
 			   </form>  
   		</div>

	</body>
</html>