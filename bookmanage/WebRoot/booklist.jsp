<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'booklist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="content-type" content="test/html; charset=gbk">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <style type="text/css">
             *{margin:0;padding: 0;}
              body {background-color:darkkhaki; font-style: italic;}
             .add{
                 width: 260px;height: 40px; font-size: 26px; background-color: blue;
                 margin-top: 100px;
                 margin-left: 130px;
                 
             }
             .tab{
             
                 margin-top: 18px;
                 margin-left: 128px;
              }
    </style>
  </head>
  
  <body>
        <table border="5" bordercolor="red" class="tab">
             <tr>
                       <td>编号</td>
                       <td>主键</td>
                       <td>书的名称</td>
                       <td>书的介绍</td>
                       <td>书的出版社</td>
                       <td>书的出版日期</td>
                       <td>书的加入日期</td>
                       <td>单价</td>
                       <td>数量</td>
                     
                       <td>删除</td>
                     
             </tr>
           
            <c:forEach items="${requestScope.bookStocks }" var="bookStock" varStatus="num" >
                    <tr>
                    
                           <c:url value="/BookStockSer" var="delete">
                              <c:param name="id" value="${bookStock.id}"></c:param>
                           </c:url>
                           
                          
                              <td>${num.count}</td>
                              <td>${bookStock.id }</td>
                              <td>${bookStock.bookName }</td>
                              <td>${bookStock.bookContent }</td>
                              <td>${bookStock.publisher }</td>
                              <td>${bookStock.publishingDate }</td>
                              <td>${bookStock.addDate }</td>
                              <td>${bookStock.bookPrice}</td>
                              <td>${bookStock.bookNumber }</td>
                              <td><a href="${delete}&statu=delete">删除</a></td>
                            
                              
                    </tr>
            </c:forEach>
                
    	         <a href="insertBookStock.jsp"><input type="button" value="新增" class="add"/><</a>
        </table>
  </body>
</html>
