<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<title>添加管理员</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" rel="stylesheet">
<style type="text/css">
ul{
	list-style: none;
	padding-top:10px;
}
li{
	padding:5px;
}
</style>

<script type="text/javascript">
function check(form){
	if(form.name.value==""){
		alert("请输入管理员名称!");form.name.focus();return;
	}
	if(form.pwd.value==""){
		alert("请输入管理员密码!");form.pwd.focus();return;
	}
	if(form.pwd1.value==""){
		alert("请确认管理员密码!");form.pwd1.focus();return;
	}		
	if(form.pwd.value!=form.pwd.value){
		alert("您两次输入的管理员密码不一致，请重新输入!");form.pwd.focus();return;
	}
	form.submit();
}
</script>
</head>
<body>
<section style="background-image: url(Images/subBG.png);width:292px;height:170px;">
	<form name="form1" method="post" action="manager?action=managerAdd">
	<ul>
		<li>管理员名称：<input name="name" type="text"></li>
		<li>管理员密码：<input name="pwd" type="password" id="pwd"></li>
		<li>确认　密码：<input name="pwd1" type="password" id="pwd1"></li>
		<li style="text-align: center"><input name="Button" type="button" value="保存" onClick="check(form1)">
&nbsp;
<input name="Submit2" type="button" value="关闭" onClick="window.close();"></li>
	</ul>
</form>
</section>
</body>
</html>
