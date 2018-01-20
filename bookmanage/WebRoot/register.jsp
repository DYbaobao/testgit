<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
			       background-color: #4169E1;
			       margin-top:104px ;
			       margin-left:316px ;
			      
			}
			td{height:70px ; width: 293px; padding-left:88px ;
			     font-size:19px ;
			}
			.main_td{width:224px ; height:30px ;}
			.main_td_1{width:73px ; height:46px ; font-size:20px ;       background-color:lawngreen ;}
		   .se{
		   	   width:235px ; height:52px ;
		   	   font-size:26px ;
		   }
		</style>
  </head>
  
  <body>
        
        
                     
       
       
       <form action="/bookmanage/UserSer" method="post">
		 	<div class="top"><h1>图书管理系统*注册</h1></div>
		   <div class="main">
		           <table >
		           	   <tr>
		           	     	<td>用户名</td>
		           	     	<td><input type="text" name="username"   class="main_td"/></td>
		           	   </tr>
		           	  <tr>
		           	     	<td>密&nbsp;码 </td>
		           	     	<td><input type="text"  name="password" class="main_td"  /></td>
		           	   </tr>
		           	    <tr>
		           	    	 <td>资金</td>
		           	    	<td > <select name="money" name="money" class="se">
                             <option value="6000.00" >6000.00</option>
                             <option value="7000.00" >7000.00</option>
                             <option value="8000.00">8000.00</option>
                             <option value="9000.00">9000.00</option>
                             <option value="10000.00">10000.00</option>
                             <option value="10100.00">10100.00</option>
                             <option value="10200.00">10200.00</option>
                             <option value="10300.00">10300.00</option>
                             <option value="10600.00">10600.00</option>
                             <option value="10800.00">10800.00</option>
                             <option value="20000.00">20000.00</option>
                             <option value="30000.00">30000.00</option>
                            </select></td>
		           	    </tr>
		           	   <tr>
		           	     	<td><input type="submit" class="main_td_1" value="提交"/></td>
		           	     	<td><a href="login.jsp"><input type="button" class="main_td_1" value="返回"/></a></td>
		           	       
                           
		           	   </tr>
		           	    <input type="hidden" name="statu" value="register" /> 
		           </table>
		   </div>
		 	
		 </form>
          
           
  </body>
</html>
