<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'books.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
             *{margin:0;padding: 0;}
              body {background-color:darkkhaki; font-style: italic;}
             .main{margin-top:9px;
                       margin-left: 320px;
              }
              h1{margin-left: 534px;}
              .buy{
              
                     width:298px;
                     height:34px; 
                   
                     font-size: 26px;
                     background-color: blue;
              }
    </style>
  </head>
  
  <body>
      
          
          
          
          
          
          
          
          
          <div class="top"><h1>图书管理系统*列表</h1></div>
		   <div class="main" >
		           <table border="6"  bgcolor="greenyellow" >
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
                       <td>购买</td>
                     
             </tr>
             
             
            <c:forEach items="${requestScope.bStocks}" var="bStock" varStatus="num" >
                    <tr>
                    
                              <c:url value="/buybook.jsp" var="buy">
                                   <c:param name="id" value="${bStock.id }"></c:param>
                                   <c:param name="bookName" value="${bStock.bookName }"></c:param>
                                   <c:param name="bookContent" value="${bStock.bookContent }"></c:param>
                                   <c:param name="publisher" value="${bStock.publisher }"></c:param>
                                   <c:param name="publishingDate" value="${bStock.publishingDate }"></c:param>
                                   <c:param name="addDate" value="${bStock.addDate }"></c:param>
                                   <c:param name="bookPrice" value="${bStock.bookPrice}"></c:param>
                                   <c:param name="bookNumber" value="${bStock.bookNumber }"></c:param>
                              </c:url>
                              
                              <td>${num.count}</td>
                              <td>${bStock.id }</td>
                              <td>${bStock.bookName }</td>
                              <td>${bStock.bookContent }</td>
                              <td>${bStock.publisher }</td>
                              <td>${bStock.publishingDate }</td>
                              <td>${bStock.addDate }</td>
                              <td>${bStock.bookPrice}</td>
                              <td>${bStock.bookNumber }</td>
                              <td><a href="${buy}">购买</a></td>
                              
                    </tr>
            </c:forEach>
                
    	     <c:url value="/ShoppingCartSer" var="selectShoppingCart">
                <c:param name="Uid" value="${sessionScope.user.id}"></c:param>
             </c:url>
             <a href="${selectShoppingCart }&statu=selectShoppingAll"><input type="button" value="我的购物车" class="buy" /></a>
		           </table>
		   </div>
          
          
          
          
          
          
          
            
  </body>
</html>
