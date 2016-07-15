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
			href="./styles/jqueryui/jquery-ui-1.10.3.custom.min.css">
			<link type="text/css" rel="stylesheet"
			href="./styles/darktooltip/darktooltip.min.css">
		 
		<link rel="stylesheet" type="text/css"
			href="./styles/familytree/style.css">
        <STYLE type="text/css">
        .ui-front {
		    z-index: 1500;
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
		<script type="text/javascript" src="./scripts/common/dateUtil.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/scripts/jeasyui/jquery.validate.js"></script>

		<script type="text/javascript" src="./scripts/jqform/jquery.form.js"></script>
 

		<script type="text/javascript" src="./scripts/autoshape/autoshape.js"></script>
		 
		<script type="text/javascript"
			src="./scripts/familytree/familytree.js"></script>

		<script type="text/javascript"
			src="./scripts/ContextMenu/jquery.contextmenu.r2.js"></script>

      		<script type="text/javascript"
			src="./scripts/darktooltip/jquery.darktooltip.min.js"></script>

		<script type="text/javascript"
			src="./scripts/frontstage/pedigree/pedigree.js"></script>

		<script type='text/javascript' src='/weibo/dwr/engine.js'></script>
		<script type='text/javascript'
			src='/weibo/dwr/interface/UserinfoService.js'></script>
        <script type='text/javascript'
            src='/weibo/dwr/interface/ReviewService.js'></script>
		<script type='text/javascript' src='/weibo/dwr/util.js'></script>
		
 

 		

       <script type="text/javascript">
             var optionStatus="<%=request.getAttribute("optionStatus") %>";
             
         </script> 

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
										<a href="./csdn/UserinfoAction_showUserinfo.action">账户设置</a>
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
		<div id="pk-family-tree"
			style="margin: 0 auto; margin-top: 100px; width: 1200px"></div>
		<!-- 弹出层定义-->
		<div id="showBtnWindow" style="display: none"> 
			<div class="modal-backdrop"></div>
			<div class="personaddbtn">
				<div class="peopleBox man center"
					style="left: 594.5px; top: 335px; z-index: 9;">
					<div id="peopleMain" class="row-fluid">
						<div class="avabox">
							<img class="avatar" alt="" src="./images/headpic/woman.jpg" id="showBtnWindow_headImg">
						</div>
						<div class="span14">
							<p class="tree-name" id="showBtnWindow_currentName">
								 
							</p>
						</div>
					</div>
	
				</div>
				<span class="abox" style="left: 474.5px; top: 215px;" id='fbtn'>
					<div class="abtn">
						添加父亲
					</div> </span>
				<span class="abox" style="left: 714.5px; top: 215px;" id='mbtn'>
					<div class="abtn">
						添加母亲
					</div> </span>
				<span class="abox" style="left: 834.5px; top: 355px;" id='pbtn'>
					<div class="abtn">
						添加对象
					</div> </span>
				<span class="abox" style="left: 474.5px; top: 495px;"  id='sbtn'>
					<div class="abtn">
						添加儿子
					</div> </span>
				<span class="abox" style="left: 714.5px; top: 495px;" id='dbtn'>
					<div class="abtn">
						添加女儿
					</div> </span>
	
			</div>
         </div>
         
         <!-- 新增弹出层 -->
        <div id="dialogFormNew" title="添加亲属" style="z-index: 2000;display: none;">
		  <form id="formNew" action="${pageContext.request.contextPath }/csdn/UserinfoAction_addFamilyMember.action" method="post">
		  
		   <div style="display: block;clear: both;">
				<label id="edit_anniversary_name_Label" for="newTrueName" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 *真实姓名
		        </label>
	 			<input id="newTrueName"  name="trueName"  type="text" style="width: 220px;float: left;"/>
		   </div>
		  
		   <div style="display: block;clear: both;">
				<label id="edit_anniversary_date_Label" for="newBirthday"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			*出生日期
		        </label>
	 			<input id="newBirthday" type="text"  name="birthday"   style="width: 220px;float: left;"/>
			</div>
	      <div style="display: block;clear: both;">
				<label id="edit_anniversary_name_Label" for="edit_anniversary_name" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 是否健在
		        </label>
		        <input type="radio" value="1" name="active"   style="float: left;margin-left: 1px;"><span style="float: left; ">健在</span>
	 		    <input type="radio" value="0" name="active"    style="float: left;margin-left: 13px;"><span style="float: left;">去世</span>

		   </div>
		    <div style="display: block;clear: both;">
				<label id="edit_anniversary_name_Label" for="newWork" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 现任工作
		        </label>
	 			<input id="newWork"  name="work"  type="text" style="width: 220px;float: left;"/>
		   </div>
		    <div style="display: block;clear: both;">
				<label id="edit_anniversary_date_Label" for="newDieday"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			去世日期
		        </label>
	 			<input id="newDieday" type="text"  name="dieday"   style="width: 220px;float: left;"/>
			</div>
		   <div style="display: block;clear: both;">
				<label id="edit_anniversary_comment_Label" for="newComment"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			自我介绍
		        </label>
				<textarea id="newComment"  name="comment"   style="width: 220px; float: left;"></textarea>
			</div>
			  <input type="hidden" id="newsex" name="sex">
			  <input type="hidden" id="newFamilyId" name="familyId">
		      <input type="hidden" id="newParentId" name="parentId">
		      <input type="hidden" id="newSpouseId" name="spouseId">
		      <input type="hidden" id="newLevel" name="level">
		    
		      <input type="hidden" id="referenceUserinfoId" name="referenceUserinfoId">
			 <input type="submit" id="newSubmit" style="display: none;">
		  </form>	
		</div>
    <!--右键菜单的源-->
     <div class="contextMenu" id="myMenu1">
      <ul>
         <li id="edit">编辑</li>
         <li id="invite">邀请</li>
       </ul>
    </div>
     <!-- 编辑弹出层-->
         <div id="dialogFormEdit" title="编辑亲属" style="z-index: 2000;display: none;">
		  <form id="formEdit" action="${pageContext.request.contextPath }/csdn/UserinfoAction_updateFamilyMember.action" method="post">
		  
		   <div style="display: block;clear: both;">
				<label   for="editTrueName" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 *真实姓名
		        </label>
	 			<input id="editTrueName"  name="trueName"  type="text" style="width: 220px;float: left;"/>
		   </div>
		  
		   <div style="display: block;clear: both;">
				<label   for="editBirthday"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			*出生日期
		        </label>
	 			<input id="editBirthday" type="text"  name="birthday"   style="width: 220px;float: left;"/>
			</div>
	      <div style="display: block;clear: both;">
				<label  for="edit_anniversary_name" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 是否健在
		        </label>
		        <input type="radio" value="1" name="active"   style="float: left;margin-left: 1px;"><span style="float: left; ">健在</span>
	 		    <input type="radio" value="0" name="active"    style="float: left;margin-left: 13px;"><span style="float: left;">去世</span>

		   </div>
		    <div style="display: block;clear: both;">
				<label   for="editWork" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 现任工作
		        </label>
	 			<input id="editWork"  name="work"  type="text" style="width: 220px;float: left;"/>
		   </div>
		    <div style="display: block;clear: both;">
				<label  for="editDieday"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			去世日期
		        </label>
	 			<input id="editDieday" type="text"  name="dieday"   style="width: 220px;float: left;"/>
			</div>
		   <div style="display: block;clear: both;">
				<label id="edit_anniversary_comment_Label" for="editComment"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			自我介绍
		        </label>
				<textarea id="editComment"  name="comment"   style="width: 220px; float: left;"></textarea>
			</div>
			  <input type="hidden"   name="id">
 			 <input type="submit" id="editSubmit" style="display: none;">
		  </form>	
		</div>
     <!-- 邀请弹出层 -->
           <div id="dialogFormInvite" title="邀请" style="z-index: 2000;display: none;">
 			   <div style="display: block;clear: both;">
					<label   for="memberId" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
			   			 *会员号
			        </label>
		 			<input id="memberId"  name="memberId"  type="text" style="width: 220px;float: left;"/>
 			   </div>
 			 	  <input type="hidden"   id="cometoId">
   	</div>  
	</body>
</html>