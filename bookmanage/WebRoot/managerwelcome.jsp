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
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <style type="text/css">
			*{margin:0 ; padding: 0;}
			body {background-color:darkkhaki; font-style: italic;}
			.top{width:600px ;height:40px ; margin-left:316px ;
			    margin-top:10px ;  
			        
			           position: relative;
			           top:78px;
			           padding-left:142px ;
			           
			           color:royalblue ;
			}
			.main{height:288px ; width:600px ;
			       border: 2px solid gold;
			       background-color: mediumorchid;
			       margin-top:104px ;
			       margin-left:316px ;
			      
			}
		 
			.main_td{
				width: 519px;
				height:40px ;
				
			}
			.sou{margin-top: -180px;}
			.ti{
				margin-top: 171px;
				width: 200px;
				height: 60px;
				margin-left: 207px;
				font-size:26px ;
				background-color:greenyellow;
			}
		</style>
  </head>
  
  <body>
        <!--  <form action="/bookmanage/BookStockSer" method="post">
               <input type="text" name="bookName" />
               <input type="submit" value="查询" />
               <input type="hidden" name="statu" value="selectBookStock">
         </form>  -->
         
         <form action="/bookmanage/BookStockSer" method="post">
		 	<div class="top"><h1>图书管理系统*搜索</h1></div>
		   <div class="main">
		           <table class="sou" border="2" bgcolor="grey" >
		           	   <tr>
		           	     	<td class="main_td">书的名字</td>
		           	     	<td><input type="text" name="bookName"  class="main_td"/></td>
		           	   </tr>
		           	
		           	  <input type="submit" value="提交" class="ti" />
		           	  <input type="hidden" name="statu" value="selectBookStock" />
		           </table>
		   </div>
		 	
		 </form>
  </body>
</html>
