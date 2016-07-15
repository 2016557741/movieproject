<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示所有Movie</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
	
	<link rel="shortcut icon" href="<%=basePath%>images/logo.png">
	
  </head>
  
  <body>
    <header>
       <div class="logo"><i class="fa fa-ul fa-cutlery"></i> MovieMUC</div>
       <div class="account">
         <c:choose>
	       <c:when test="${user.name ==null}">
	         <a href="reg.jsp">注册</a>
	         <a href="login.jsp">登录</a>
	       </c:when>
	       <c:otherwise>
	         <c:out value="${user.name}"></c:out>, 欢迎您!
	       </c:otherwise>
	     </c:choose>
		    
       </div>
       
		    
    </header>

     <main class="container-fluid">
	    <div class="row">
		   <div class="col-md-10">
		      <s:form action="movie/movie_addMovie" cssClass="form-horizontal">
		       <div class="panel panel-success">
			       <div class="panel-heading">
		               <h4 class="panel-title"> <i class="fa fa-cutlery"></i> 添 加 电影 </h4>
		           </div>
		           <div class="panel-body">
				       <div class="form-group">
			                <label class="control-label col-md-3">电影名称</label>
			                <div class="col-md-4">
                              <input type="text" name="movie.moviename" class="form-control input-sm" required>
                           </div>
			           </div>  
			           <div class="form-group">
			                <label class="control-label col-md-3">电影导演</label>
			                <div class="col-md-2">
                              <input type="text" name="movie.unitprice" class="form-control input-sm" placeholder="&yen;" required>
                            </div>
			           </div>
			           <div class="form-group">
			                <label class="control-label col-md-3">电影图片</label>
			                <div class="col-md-4">
			                 <div class="fileupload-new" date-provides="fileupload">
			                  <div class="filepload-new thumbnail" style="width:200px; height: 150px;">
			                    <img src="<%=basePath%>upload/demoUpload.jpg" alt=""/> 
			                  </div>
			                  <div class="fileupload-preview fileupload-exists thumbnail"
			                    style="max-width: 200px;max-height:150px; Line-height: 20px;">
			                   </div> 
			                   <div>
			                   <span class="btn btn-file btn-primary">
			                    <span class="fileupload-new">换张图片</span>
			                    <span class="fileupload-exists">换张图片</span>
			                    <input type="file" name="moviePhoto"/>
			                  </span>
			                  <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">取消</a>
			                   </div>
			                </div>
			                   <span class="btn btn-file btn-primary"><</span> class="fileupload-new">浏览</div>span>
			                   <span class="fileupload-exists">浏览</span><input type="file" name="moviePhoto"/></span>
			                   <a href="#" class="btn-danger fileupload-exists" data-dismiss="fileupload">取消</a>
			                   </div>
			                 </div>
			               </div>
		              </div>        
			           <div class="form-group col-md-3">
				          <button type="submit" class="btn btn-success pull-right">提  交 </button>
				       </div>
				   </div>
				</div>
		    </s:form>
		  </div>
	   </div>
	</main>
  </body>
</html>
