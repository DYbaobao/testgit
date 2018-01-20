<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
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
  	   <table>
  	          <tr>
  	             <td>用户名</td>
  	             <td>密码</td>
  	             <td>生日</td>
  	             <td>修改</td>
  	             <td>删除</td>
  	          </tr>
  	       <c:forEach items="${pages.list}" var="p" >
  	             <tr> 
  	                <td>${p.userName }</td>
  	                <td>${p.password }</td>
  	               <td> <fmt:formatDate value="${p.birthday }" pattern="yyyy-MM-dd HH:mm:ss"  /></td>
  	              <%--   <td>${p.birthday }</td> --%>
  	                <td><a href="UserController/update?id=${p.id }">修改</a></td>
  	               <%--  <td><a href="UserController/delete?id=${p.id }">删除</a></td> --%>
  	                  <td><a href="UserController/delete/${p.id }">删除</a></td>
  	             </tr>
  	       </c:forEach>
  	   </table>
    前页码:【${pages.currPageNo }/${pages.totalPageCount}】
	
	<a href="UserController/doPage?currPageNo=1">首页</a>
	<a href="UserController/doPage?currPageNo=${pages.currPageNo-1<1?1:pages.currPageNo-1}">上一页</a>
	<a href="UserController/doPage?currPageNo=${pages.currPageNo+1<pages.totalPageCount?pages.currPageNo+1:pages.totalPageCount}">下一页</a>
	<a href="UserController/doPage?currPageNo=${pages.totalPageCount}">尾页</a>
	
    
  </body>
</html>
