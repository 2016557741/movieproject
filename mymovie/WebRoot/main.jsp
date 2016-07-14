<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  



  </head>
  <body>
  <s:form>
    <table>
     <tr>
  <th>序号</th>
  <th>名称</th>
  <th>单价</th>
    </tr>
    
      <c:forEach var="movie" items="${movieList}"> varStatus="status"
        <tr>
          <td><c:out value="status.index+1}"></c:out></td>
          <td><a href="movie/movie_showDetail?movie.movieid=${movie.movieid}">
          <td><c:out value="movie.moviename}"></c:out></td>
          <td><c:out value="movie.unitprice}"></c:out></td>
         </tr>
       </c:forEach>
      </table>
    </s:form>
   </body>
  
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
