<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%
String error=(String)request.getAttribute("error");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>错误提示</title>
<link href="CSS/style.css" rel="stylesheet">
</head>

<body>
<div style="background-image:url(Images/error.jpg);width:419px;height:136px;padding-top:90px;text-align:center;margin-top:100px;">
<img src="Images/error_b.gif" width="31" height="31">&nbsp;&nbsp;错误提示信息： <%=error%> <br>
              <br>
              <input name="Submit" type="submit" value="返回" onClick="history.back(-1)">
</div>
</body>
</html>
