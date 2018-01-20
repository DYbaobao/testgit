<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertBookStock.jsp' starting page</title>
    
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
              body {
              background-color:darkkhaki; 
              font-style: italic;
              }
              .ti{
                   height:40px ;
                  width: 200px; 
                  margin-top:100px ;
                   margin-left:100px ; 
                   position: relative;
                   top:207px;
                    left:-80px;
                    background-color: blue;
                    font-size: 20px;
                    }
              .tb{
              margin-top:16px ;
              margin-left: 532px;
              position: relative;
              }
     </style>
  </head>
  
  <body>
          <form action="/bookmanage/BookStockSer"  method="post">
               <div class="tb">
               
                   <table>
                             <tr>
                                 <td>书的名字:</td>
                                 <td><input type="text" name="bookName"/></td>
                             </tr>
                             <tr>
                                 <td>书的出版社:</td>
                                 <td><input type="text" name="publisher"/></td>
                             </tr>
                             <tr>
                                 <td>书的出版日期:</td>
                                 <td><input type="text" name="publishingDate"/></td>
                             </tr>
                             <tr>
                                 <td>书的价格:</td>
                                 <td><input type="text" name="bookPrice"/></td>
                             </tr>
                             <tr>
                                 <td>书的 数量:</td>
                                 <td><input type="text" name="bookNumber"/></td>
                             </tr>
                             <tr>
                                 <td> 书的介绍:</td>
                                 <td> <textarea rows="3" cols="18" name="bookContent"></textarea> </td>
                             </tr>
                             
                              <input type="submit" value="提交" class="ti">    
                            <input type="hidden" name="statu" value="insertBookStock">  
                             
                   </table>
               </div>
                                  
                                   
                                 
                                       
                                   
                                
             
          </form>
  </body>
</html>
