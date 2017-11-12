<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.entity.BookCaseForm" %>
<%@ page import="cn.jju.library.dao.ChStr" %>
<!DOCTYPE HTML>
<html>
<head>
<title>修改书架信息</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
</head>

<body>
<%
BookCaseForm bookCaseForm=(BookCaseForm)request.getAttribute("bookCaseQueryif");
%>
<section style="background-image: url(Images/subBG.jpg);width:292px;height:175px;text-align: center">
<form name="form1" method="post" action="bookCase?action=bookCaseModify">
	<div style="padding-top:45px;padding-bottom:30px;">书架名称：
	<input name="id" type="hidden" size="50" value="<%=bookCaseForm.getId()%>">
    <input name="name" type="text" value="<%=bookCaseForm.getName()%>"></div>
	<div><input name="Submit" type="submit" value="保存">
&nbsp;
<input name="Submit2" type="reset" value="重置">
&nbsp;
<input name="Submit3" type="button" onClick="window.close()" value="关闭"></div>
</form>
</section>
</body>
</html>
