<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<title>添加书架信息</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet">
</head>

<body>
<section style="background-image: url(Images/subBG.jpg);width:292px;height:175px;text-align: center">
<form name="form1" method="post" action="bookCase?action=bookCaseAdd">
	<div style="padding-top:45px;padding-bottom:30px;">书架名称： <input name="name" type="text"></div>
	<div><input name="Submit3" type="submit" value="保存"> &nbsp;
     <input name="Submit22" type="button" value="关闭" onClick="window.close();"></div>
</form>
</section>
</body>
</html>
