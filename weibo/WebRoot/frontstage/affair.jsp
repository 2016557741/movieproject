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
			href="./styles/jqueryui/plug/jquery-ui-timepicker.css">
		<link type="text/css" rel="stylesheet"
			href="./styles/frontstage/affair/base-standard.css">
		<link type="text/css" rel="stylesheet"
			href="./styles/frontstage/affair/affair.css">


		<script type="text/javascript"
			src="./scripts/jquery/jquery-1.9.1.min.js"></script>

		<script type="text/javascript"
			src="./scripts/jqueryui/jquery-ui-1.10.3.custom.js"></script>
		<script type="text/javascript"
			src="./scripts/jqueryui/extend/jq-ui-extend.js"></script>
		<script type="text/javascript"
			src="./scripts/jqueryui/plug/jquery-ui-timepicker.js"></script>

 		<script type="text/javascript"
			src="./scripts/frontstage/common/head.js"></script>
		<script type="text/javascript" src="./scripts/common/dateUtil.js"></script>


		<script type="text/javascript"
			src="./scripts/frontstage/affair/affair.js"></script>
			
	     <script type='text/javascript' src='/weibo/dwr/engine.js'></script>
 		 <script type='text/javascript' src='/weibo/dwr/interface/AffairService.js'></script>
  		 <script type='text/javascript' src='/weibo/dwr/util.js'></script>
			


	</head>
	<body data-spy="scroll" data-target=".bs-docs-sidebar"
		data-twttr-rendered="true" screen_capture_injected="true" style="overflow:auto;">
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
							<li class="active padding_34">
								<div class="activearrow"></div>
								<a class="big_title" href="./csdn/AffairAction_queryAffairList.action">家庭事件</a>
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
		<div class="container1"  >
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tbody>
					<tr>
						<td width="100%">
							<span style="display: none" id="automation_events_page"></span>
						</td>
					</tr>
					<tr>
						<td width="100%">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tbody>
									<tr>
										<td>
											<div class="Breadcrumbs">
												<span id="BreadcrumbsFinalText" class="FL_LabelLargeBold">家庭活动</span>
											</div>
										</td>
										<td style="vertical-align: bottom; text-align: right">
											<a  
												href="javascript:void(0)" id="newActive"
												class="FL_Link">发布活动</a>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td width="100%">
							<table border="0" cellpadding="0" cellspacing="0">
								<tbody>
									<tr height="11">
										<td nowrap="nowrap"></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td width="100%">

							<div class="StandardRoundedPanel LightBlueRoundedPanel">
								<table
									style="position: relative; top: -1px; margin-bottom: -2px"
									align="center" border="0" cellpadding="0" cellspacing="0"
									width="100%">
									<form style="margin: 0px;" id="searchFormID" name="search"
										method="get" action="/FP/events.php" onsubmit="return false;"></form>
									<input name="s" id="s" value="223549271" type="hidden">
									<input name="lang" id="lang" value="ZH" type="hidden">
									<input name="page" value="1" type="hidden">
									<input name="action" value="search" type="hidden">
									<tbody>
										<tr>
											<td>
												<table border="0" cellpadding="0" cellspacing="0"
													width="100%">
													<tbody>
														<tr>
														<form id="searchAffairForm" action="${pageContext.request.contextPath }/csdn/AffairAction_queryAffairList.action" method="post">
															<td>
																<div style="width: 80px;text-align: right;">发布内容：</div>
	   														</td>
															<td>
																<input size="5" maxlength="255"
  																	class="FL_FieldText InvitationTextareaShaded"
  																	id="commentSearc"
																	name="comment"  value="<s:property value="#request.conditionMap.comment"/>"
 																	style="padding-top: 2px; width: 150px; height: 22px;"
 																	  type="text">
	   														</td>
	   														<td>
																<div style="width: 60px;text-align: right;;">发布人：</div>
	   														</td>
															<td>
																<input size="5" maxlength="255"
  																	class="FL_FieldText InvitationTextareaShaded"
  																	id="trueNameSearc"
																	name="trueName"  value="<s:property value="#request.conditionMap.trueName"/>"
 																	style="padding-top: 2px; width: 150px; height: 22px;"
 																	  type="text">
															</td>
															<td>
																<div style="width: 100px;text-align: right;;">活动时间从：</div>
	   														</td>
															<td>
																<input size="5" maxlength="255"
  																	class="FL_FieldText InvitationTextareaShaded"
																	name="affairDateFrom"   id="affairDateFrom" value="<s:property value="#request.conditionMap.affairDateFrom"/>"
 																	style="padding-top: 2px; width: 150px; height: 22px;"
 																	  type="text">
															</td>
															<td>
																<div style="width: 100px;text-align: right;;">活动时间到：</div>
	   														</td>
															<td>
																<input size="5" maxlength="255"
  																	class="FL_FieldText InvitationTextareaShaded"
																	name="affairDateTo"  id="affairDateTo" value="<s:property value="#request.conditionMap.affairDateTo"/>"
 																	style="padding-top: 2px; width: 150px; height: 22px;"
 																	  type="text">
															</td>
															<td style="padding-left: 5px" nowrap="nowrap">
																<div id="clearButton"
																	class="Clickable ClickableSearchGoBtnRTL" 
  																	style="margin-top: 2px;" title="清空查询"></div>
  																 
  																	 
															</td>
															<td style="padding-left: 5px" nowrap="nowrap">
																<div id="goSearcButton"
																	class="Clickable ClickableSearchGoBtnLTR"
  																	style="margin-top: 2px;" title="开始搜索"></div>
  																	<input type="submit" id="submit1" style="display: none;"/>
  																	 
															</td>
 															<td width="100%"></td>
 															</form>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
 										<input name="aSearch" value="" type="hidden">
										<input name="editBoxInitialText" value="寻找活动" type="hidden">
									</tbody>
								</table>
							</div>
						</td>
					</tr>
					<s:iterator value="#request.affairList"  id="affair"  status="status">  
 					<tr id='<s:property value="#affair.id"/>_affair'>
						<td width="100%">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tbody>
									<tr>
										<td id="eventsMainContent" align="center" width="100%">
											<table border="0" cellpadding="0" cellspacing="0"
												width="100%">
												<tbody>
													<tr>
														<td class="MonthAndYear" colspan="4">
															<a
																href="javascript:void(0);"
																class="FL_LinkLargeBold"><s:date name="#affair.date" format="M" />月       <s:date name="#affair.date" format="yyyy" /></a>
														</td>
													</tr>
													<tr id="row_61" class="FirstRow">
														<td class="DatePart" width="20%">
															<div class="GrayOutDiv">
																<div class="CommonIcons WhiteCalendar">
																	<div class="DayOfWeek FL_LabelSmall">
																		 <s:date name="#affair.date" format="yyyy" />
																	</div>
																	<a class="DayOfMonth FL_LinkLargeBold"
																		href="javascript:void(0);"><s:date name="#affair.date" format="dd" /></a>
																	<div class="MonthAbbr FL_LabelSmall">
																		<s:date name="#affair.date" format="M" />月
																	</div>
																</div>
															</div>
														</td>
														<td class="ImagePart" width="20%">
															<div class="GrayOutDiv">
															<s:set name="nowTime" value="new java.util.Date()"></s:set>
															<s:set name="affairDate" value="#affair.date"></s:set>
															
                                                            <s:if test='#affairDate.getTime()<#nowTime.getTime()'>
																<img
																	src="./images/affair/spacer.gif"
																	class="CommonIcons noActiveCalendarSmall" title="过期"/>
														    </s:if>
														    <s:else>
														       <img
																	src="./images/affair/spacer.gif"
																	class="CommonIcons activeCalendarSmall" title="生效"/>
														    </s:else>	
															</div>
														</td>
														<td class="TitlePart">
															<div class="GrayOutDiv" width="55%">
																<span class="FL_Label"><a
																	href="javascript:void(0); "
																	class="FL_LinkLarge"><s:property value="#affair.comment"/> </a> <br> <s:date name="#affair.date" format="HH:mm" /><br><s:property value="#affair.userinfo.trueName"/></span>
															</div>
														</td>
														<td class="DeletePart" width="5%">
  														    <s:if test="#affair.userinfo.id==#session.user.userinfo.id">
 																<a href="javascript:void(0);" class="deleteAffairBtn" affairId='<s:property value="#affair.id"/>'><img
																	id="img_61"
																	src="./images/affair/spacer.gif"
																	class="Clickable ClickableDelete"
																	 > </a>
														    </s:if>
														    <s:else>
														      
														    </s:else>	
															
														</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					  </s:iterator>  
				</tbody>
			</table>
		</div>
		
		<div id="newActiveDialog" title="发布活动">
 		   <div style="display: block;clear: both;">
				<label id="new_anniversary_name_Label"  for="affairComment" style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			 *发布内容
		        </label>
 	 			 <textarea id="affairComment"  name="comment"   style="width: 220px; float: left;"></textarea>
		   </div>
	 
		    <div style="display: block;clear: both;">
				<label id="new_anniversary_date_Label" for="affairDate"  style="float: left;margin-right: 10px;font-size: 14px;line-height: 30px">
		   			*活动时间
		        </label>
	 			<input id="affairDate" type="text" name="date" style="width: 220px;float: left;"/>
			</div>
 		</div>

	</body>
</html>