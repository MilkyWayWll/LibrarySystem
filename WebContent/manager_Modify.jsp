<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.entity.ManagerForm"%>
<%
ManagerForm managerForm=(ManagerForm)request.getAttribute("managerQueryif");
int ID=managerForm.getId().intValue();
String	name=managerForm.getName();
int sysset=managerForm.getSysset();
int readerset=managerForm.getReaderset();
int bookset=managerForm.getBookset();
int borrowback=managerForm.getBorrowback();
int sysquery=managerForm.getSysquery();
%>
<!DOCTYPE HTML>
<html>
<head>
<title>权限设置</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<style type="text/css">
ul{
	list-style: none;
	padding-top:10px;
	padding-left:10px;
}
li{
	padding:3px;
}
li ul{
	padding:0px;
}
</style>
</head>
<body>
<section style="background-image: url(Images/subBG.jpg);width:292px;height:175px;">
	<form name="form1" method="post" action="manager?action=managerModify">
	<ul>
		<li>管理员名称：<input name="id" type="hidden" value="<%=ID%>"><input name="name" type="text" readonly="yes" value="<%=name%>"></li>
		<li>拥有的权限：
			<ul>
				<li style="float:left"><input name="sysset" type="checkbox" class="noborder" id="sysset" value="1" <%if(sysset==1){out.println("checked");}%>>
	系统设置</li>
				<li style="float:left"><input name="readerset" type="checkbox" class="noborder" id="readerset" value="1" <%if(readerset==1){out.println("checked");}%>>
	              读者管理</li>
	              <li><input name="bookset" type="checkbox" class="noborder" id="bookset" value="1" <%if(bookset==1){out.println("checked");}%>>
	              图书管理</li>
	              <li style="float:left"><input name="borrowback" type="checkbox" class="noborder" id="borrowback" value="1" <%if(borrowback==1){out.println("checked");}%>>
	              图书借还</li>
	          <li><input name="sysquery" type="checkbox" class="noborder" id="sysquery" value="1" <%if(sysquery==1){out.println("checked");}%>>
	              系统查询</li>
			</ul>
		</li>
		<li style="text-align: center"><input name="Button" type="submit" value="保存">
&nbsp;
<input name="Submit2" type="button" value="关闭" onClick="window.close();"></li>
	</ul>
</form>
</section>
</body>
</html>
