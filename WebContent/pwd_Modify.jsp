<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.entity.ManagerForm" %>
<!DOCTYPE HTML>
<html>
<%
ManagerForm managerForm=(ManagerForm)request.getAttribute("pwdQueryif");
%>
<head>
<title>图书馆管理系统</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<style type="text/css">
div ul{
	list-style: none;
	padding-top:15px;
}
div li{
	padding:10px;
}
</style>
</head>
<script language="javascript">
function checkForm(form){
	if(form.oldpwd.value==""){
		alert("请输入的原密码!");form.oldpwd.focus();return false;
	}
	if(form.oldpwd.value!=form.holdpwd.value){
		alert("您输入的原密码不正确，请重新输入!");form.oldpwd.value="";
		form.oldpwd.focus();return false;
	}
	if(form.pwd.value==""){
		alert("请输入的新密码!");form.pwd.focus();return false;
	}	
	if(form.pwd1.value==""){
		alert("请确认新密码!");form.pwd1.focus();return false;
	}	
	if(form.pwd.value!=form.pwd1.value){
		alert("您两次输入的新密码不一致，请重新输入!");
		form.pwd.value="";form.pwd1.value="";
		form.pwd.focus();return false;
	}
}
</script>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：更改口令 &gt;&gt;&gt;</div>
<div style="height:300px;padding-left:20px;">
 <form name="form1" method="post" action="manager?action=modifypwd">
 
 <ul>
		<li>管理员名称：<input name="name" type="text" id="name" value="<%=managerForm.getName()%>" readonly size="30"></li>
		<li>原　密　码：<input name="oldpwd" type="password" id="oldpwd" size="30">
      <input name="holdpwd" type="hidden" id="holdpwd" value="<%=managerForm.getPwd()%>"></li>
      <li>新　密　码：<input name="pwd" type="password" id="pwd" size="30"></li>
      <li>确认新密码：<input name="pwd1" type="password" id="pwd1" size="30"></li>
		<li ><input name="Submit" type="submit" value="保存" onClick="return checkForm(form1)">
        &nbsp;
        <input name="Submit2" type="reset" value="取消"></li>
	</ul>
</form>
</div>
</section>
<%@ include file="copyright.jsp"%>
</body>
</html>
