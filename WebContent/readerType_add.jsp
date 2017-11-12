<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<title>添加读者类型信息</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
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
<script type="text/javascript">
function check(form){
	if(form.name.value==""){
		alert("请输入类型名称!");form.name.focus();return false;
	}
	if(form.number.value==""){
		alert("请输入可借数量!");form.number.focus();return false;
	}	
}
</script>
<body>
<section style="background-image: url(Images/subBG.jpg);width:292px;height:175px;">
		<form name="form1" method="post" action="readerType?action=readerTypeAdd">
	<ul>
		<li>类型名称：<input name="name" type="text" size="20"></li>
		<li>可借数量：<input name="number" type="text" id="number" size="18">(本)</li>
		<li style="text-align: center"><input name="Submit" type="submit" value="保存" onClick="return check(form1)">
          &nbsp;
          <input name="Submit2" type="button" value="关闭" onClick="window.close();"></li>
	</ul>
</form>
</section>
</body>
</html>
