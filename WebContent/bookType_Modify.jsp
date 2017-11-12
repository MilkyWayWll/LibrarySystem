<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.entity.BookTypeForm" %>
<%@ page import="cn.jju.library.dao.ChStr"%>
<!DOCTYPE HTML>
<html>
<head>
<title>修改图书类型信息</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/style.css">
<style type="text/css">
ul{
	list-style: none;
	padding-top:15px;
}
li{
	padding:10px;
}
</style>
</head>

<body>
<%
BookTypeForm bookTypeForm=(BookTypeForm)request.getAttribute("bookTypeQueryif");
ChStr chStr=new ChStr();
%>
<section style="background-image: url(Images/subBG.jpg);width:292px;height:175px;">
	<form name="form1" method="post" action="bookType?action=bookTypeModify">
	<input name="id" type="hidden" size="50" value="<%=bookTypeForm.getId()%>"> 
	<ul>
		<li>类型名称：<input name="typeName" type="text" size="20" value="<%=bookTypeForm.getTypeName()%>"></li>
		<li>可借天数：<input name="days" type="text" size="15" value="<%=bookTypeForm.getDays()%>"> (天)</li>
		<li style="text-align: center"><input name="Submit" type="submit" value="保存">
&nbsp;
<input name="Submit2" type="reset" value="重置">
&nbsp;
<input name="Submit3" type="button" onClick="window.close()" value="关闭"></li>
	</ul>
</form>
</section>
</body>
</html>
