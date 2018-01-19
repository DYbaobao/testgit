<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
     <c:if test="${empty requestScope.employees  }">
                     没有任何信息
     </c:if>
     <c:if test="${requestScope.employees }">
         <table border="1" cellpadding="10" cellspacing="0">
           <tr>
                 <th>ID</th>
                 <th>LastName</th>
                 <th>Email</th>
                 <th>Gender</th>
                 <th>Department</th>
                 <th>Edit</th>
                 <th>Delete</th>
           </tr>
           <c:forEach items="${requestScope.employees  } " var="emp">
                     <tr>
                         <td>${emp.id }</td>
                         <td>${emp.lastName}</td>
                         <td>${emp.email }</td>
                         <td>${emp.gender==0?'Female':'Male' }</td>
                         <td>${emp.department.departmentName }</td>
                         <td><a href="">Edit</a></td>
                         <td><a href="">Delete</a></td>
                     </tr>
           </c:forEach>
         </table>
     </c:if>
  </body>
</html>
