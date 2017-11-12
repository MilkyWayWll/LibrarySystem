<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
<title>图书馆管理系统</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<style type="text/css">
ul{
	list-style: none;
	padding-top:100px;
	padding-left:240px;
}
li{
	padding:5px;
	color:#FFFFFF;
}
</style>
<script type="text/javascript">
function check(form){
	if (form.name.value==""){
		alert("请输入管理员名称!");form.name.focus();return false;
	}
	if (form.pwd.value==""){
		alert("请输入密码!");form.pwd.focus();return false;
	}	
}
</script>
</head>
<body>
<div  width:603px;class="tableBorder">
	<div style="background-image:url(Images/login.jpg);width:603px;height:240px;margin-top:192px;margin-left:120px;">
         <form name="form1" method="post" action="manager?action=login">
              <ul>
              	<li>管理员名称：<input name="name" type="text" class="logininput" id="name" size="20"></li>
                <li>管理员密码：<input name="pwd" type="password" class="logininput" id="pwd" size="20"></li>
                <li><input name="Submit" type="submit" value="确定" onClick="return check(form1)">
                        &nbsp;
                        <input name="Submit3" type="reset"  value="重置">&nbsp;
                        <input name="Submit2" type="button" value="关闭" onClick="window.close();"></li>
              </ul>
         </form>    
    </div>
</div>
</body>
</html>
