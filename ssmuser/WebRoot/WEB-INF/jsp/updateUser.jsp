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
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!--       <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
      <script type="text/javascript">
      $.ajax({
    	  type: "POST",
          url:$('form').submit(), 
          data:{"userName":"${user.userName }","id":"${user.id 

}","password":"${user.password }","birthday":"${user.birthday }"},
          dataType: "json",
          contentType: "application/json;charset=utf-8"
      });
      </script> -->
  </head>
  
  <body> 

   
       <form action="UserController/updateSubmit" method="post" enctype="multipart/form-data">
          用户名: <input type="text" name="userName" value="${user.userName }"  />
                     <br/>
                     <input type="hidden" name="id" value="${user.id }">
                    密码:  <input type="password" name="password" value="${user.password }"/><br/>
                     <img src="${user.path}"/>
                    图片:<img src="${pageContext.request.contextPath }/upload/${user.path}">
                    <input type="hidden" name="imurl" value="${user.path}">
                    <input type="file" name="pic">
                    <p><a href="UserController/download?fileName=${user.path}">${user.path}</a>
               日期 :<input type="text" name="birthday" value='<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd HH:mm:ss"  />' />  
            
 
             
              <input  type="submit" value="提交"/>
       
       
       
       </form> 
       
    
  </body>
</html>
