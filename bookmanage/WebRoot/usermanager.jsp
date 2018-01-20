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
    
    <title>My JSP 'usermanager.jsp' starting page</title>
    
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
       .car{width:210px;height: 46px; font-size: 26px; background-color: blue;
             position: relative; top:126px; left:301px; }
       .list{margin-top: 140px;margin-left: 300px; position: relative;}
       .cd{background-color: green; font-size:16px;}
    </style>
  </head>
  
  <body>
        <table> 
          
             <tr> 
                  <td class="cd">${requestScope.buy}</td>
                </tr>  
          </table>
             <c:url value="/ShoppingCartSer" var="selectShoppingCart">
                <c:param name="Uid" value="${sessionScope.user.id}"></c:param>
             </c:url>
             <a href="${selectShoppingCart }&statu=selectShoppingAll"><input type="button" value="我的购物车" class="car" /></a>
             <table border="5" bordercolor="red" class="list">
                        <tr>
                            <td>编号</td>
                            <td>主键</td>
                            <td>单价</td>
                            <td>数量</td>
                            <td>书名</td>
                            <td>加入的日期</td>
                            <td>出版社</td>
                            <td>出版日期</td>
                            <td>总金额</td>
                             <td>付款</td> 
                        </tr>
                       <c:forEach items="${requestScope.shoppingCarts }"   var="shoppingCart"   varStatus="num">
                           
                           
                            <tr>
                                     <td>${num.count }</td>
                                     <td>${shoppingCart.scId }</td>
                                     <td>${shoppingCart.price}</td>
                                     <td>${shoppingCart.number}</td>
                                     <td>${shoppingCart.bookName}</td>
                                     <td>${shoppingCart.addDate}</td>
                                     <td>${shoppingCart.publisher}</td>
                                     <td>${shoppingCart.publishingDate}</td>
                                     <td>${shoppingCart.price*shoppingCart.number}</td>
                                   <c:url value="/ShoppingCartSer" var="payMoney">
                                      <c:param name="scid" value="${shoppingCart.scId }"></c:param>
                                      <c:param name="uid" value="${sessionScope.user.id}"></c:param>
                                      <c:param name="bookNumber" value="${shoppingCart.number}"></c:param>
                                      <c:param name="bookName" value="${shoppingCart.bookName}"></c:param>
                                      <c:param name="bookPrice" value="${shoppingCart.price}"></c:param>
                                      <c:param name="sumMoney" value="${shoppingCart.price*shoppingCart.number}"></c:param>
                                     </c:url> 
                                     
                                      <td><a href="${payMoney}&statu=pay">付款</td>
                            </tr>
                       
                       </c:forEach>
             </table>
             <table> 
                 <tr>
                        <td class="cd">${requestScope.paymoney}</td>
                 </tr>
             </table>
  </body>
</html>
