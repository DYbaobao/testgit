<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buybook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <style type="text/css">
       body {background-color:darkkhaki; font-style: italic;}
      .tb{margin-top: 166px; margin-left: 486px;}
      </style>
  </head>
  
  <body>
             <form action="/bookmanage/ShoppingCartSer"  method="post">
  
  
             <div class="tb">
             
             <table>
                       <tr>
                            <td>书的名字:</td>
                            <td><input type="text" name="bookName" value="${param.bookName }"/></td>
                       </tr>
                         
                         <tr>
                            <td>书的出版社:</td>
                            <td><input type="text" name="publisher" value="${param.publisher }"/></td>
                       </tr>
                        
                         <tr>
                            <td>  书的出版日期:</td>
                            <td><input type="text" name="publishingDate" value="${param.publishingDate }"/></td>
                       </tr>
                         
                         <tr>
                            <td>书的价格: </td>
                            <td> <input type="text" name="bookPrice" value="${param.bookPrice }"/></td>
                       </tr> 
                       
                        <tr>
                            <td>购买 数量:</td>
                            <td><input type="text" name="bookNumber" /></td>
                       </tr> 
                       
                        <tr>
                            <td>书的介绍:</td>
                            <td><textarea rows="3" cols="18" name="bookContent" >${param.bookContent}</textarea> </td>
                       </tr>
             </table>
             
             
                                 
                                 
                                   
                                  
               <input type="submit" value="提交">   
                                  
              <input type="hidden" name="Uid" value="${sessionScope.user.id}">
              <input type="hidden" name="id" value="${param.id }" />
               <input type="hidden" name="statu" value="insertBook">   
             </div>
  
  
  
  
  
  
  
  
     
                            
              
             
             
      
      
          
             
             
               
        
      
      </form>
  </body>
</html>
