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
    
    <title>所有movie</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.css">	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
	<link rel="shortcut icon"   href="<%=basePath%>images/azj.png">
  </head>
  
  <body>
    <header>
    <div class="logo"><i class="fa fa-ul fa-cutlery"></i>MovieMuc</div>     
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
       <div class="logo"></div>
		    
    </header>
    
    <main>
	    <s:form action="movie/movie_queryMovies" method="post">
	     <div class="form-inline search-box">
              <div class="form-group pull-right mr200">
                <input class="search-field form-control input-sm" title="关键词" name="keyWords" placeholder="输入关键词...">
                <button class="btn btn-info btn-sm" type="submit">搜  索</button>
              </div> 
            </div>
	      <ul >
	        <s:if test="#session.user.name =='admin'">
	        <li>		        
		            <div class="add"><a href="add.jsp"><i class="fa fa-plus"></i> 添加电影</a></div>
		              <p>点击上面的链接可以添加一种电影</p>		        
	        </li>
	        <s:iterator value="movieList" status="status">
	          <li>
	             <img src="<%=basePath%><s:property value='filepath'/>">
	             <p>
	                <a href="movie/movie_showDetail?movie.movieid=<s:property value='movieid'/>">
	                  <s:property value="moviename"/>
	                </a>
	                <span class="price"> &yen;<s:property value="unitprice"/></span>
	                <a href="movie/movie_showEdit?movie.movieid=<s:property 
	                  value='movieid'/>">
	                  <i class="fa fa-pencil"></i> 
	                </a>
	                &nbsp;&nbsp;<a href="movie/movie_deleteMovie?movie.movieid=<s:property 
	                  value='movieid'/>">
	                  <i class="fa fa-trash"></i> 
	                </a>
	             </p>
	          </li>
	        </s:iterator>
	        </s:if>
	        <s:else>
	          <s:iterator value="movieList" status="status">
	          <li>
	             <img src="<%=basePath%><s:property value='filepath'/>">
	             <p>
	                <a href="movie/movie_showDetail?movie.movieid=<s:property value='movieid'/>">
	                  <s:property value="moviename"/>
	                </a>
	                <span class="price"> &yen;<s:property value="unitprice"/></span>
	                <a href="order/order_addOrder?food.foodid=<s:property 
	                  value='movieid'/>&user.name=<s:property value='#session.user.name'/>" class="add-order">
	                  <i class="fa fa-cutlery"></i> 订一波
	                </a>
	             </p>
	          </li>
	        </s:iterator>
	        </s:else>

	      </ul>
	    </s:form>
	</main>
  </body>
</html>

