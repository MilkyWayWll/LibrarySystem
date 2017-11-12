<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.entity.ParameterForm" %>
<!DOCTYPE HTML>
<html>
<%
ParameterForm form=(ParameterForm)request.getAttribute("parameterModifyif");
int cost=0;
int validity=0;
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
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：系统设置 &gt; 参数设置 &gt;&gt;&gt;</div>
<div style="height:300px;padding-left:20px;">

<form name="form1" method="post" action="parameter?action=parameterModify">
<%if(form!=null){
	cost=form.getCost();
	validity=form.getValidity();
}
%>
<ul>
		<li>办 &nbsp;证 &nbsp;费：<input name="cost" type="text" id="cost" value="<%=cost%>" size="30">
      (元)</li>
		<li>有效期限：<input name="validity" type="text" id="validity" size="30" value="<%=validity%>" >
      (月)</li>
		<li ><input name="Submit" type="submit"  value="保存">
        &nbsp;
        <input name="Submit2" type="reset" value="取消"></li>
	</ul>
	
</form>
</div>
</section>
<%@ include file="copyright.jsp"%>
</body>
</html>
