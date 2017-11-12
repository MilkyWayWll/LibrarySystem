<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.entity.ReaderTypeForm" %>
<%@ page import="cn.jju.library.dao.ChStr"%>
<!DOCTYPE HTML>
<html>
<head>
<title>修改读者类型信息</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/style.css">
<style type="text/css">
ul{
	list-style: none;
	padding-top:15px;
	padding-left:20px;
}
li{
	padding:10px;
}
</style>
</head>

<body>
<%
ReaderTypeForm readerTypeForm=(ReaderTypeForm)request.getAttribute("readerTypeQueryif");
ChStr chStr=new ChStr();
%>
<section style="background-image: url(Images/subBG.jpg);width:292px;height:175px;">
	<form name="form1" method="post" action="readerType?action=readerTypeModify">
	 <input name="id" type="hidden" size="50" value="<%=readerTypeForm.getId()%>"> 
	<ul>
		<li>类型名称：<input name="name" type="text" size="20" value="<%=readerTypeForm.getName()%>"></li>
		<li>可借数量：<input name="number1" type="text" size="18" value="<%=readerTypeForm.getNumber()%>">(本)</li>
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
