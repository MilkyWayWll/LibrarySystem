<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.entity.LibraryForm" %>
<!DOCTYPE HTML>
<html>
<%
LibraryForm libraryForm=(LibraryForm)request.getAttribute("libraryModifyif");
String libraryname="灵图图书馆";
String curator="张三";
String tel="15966783425";
String address="九江市";
String email="294307895@qq.com";
String url="http://***";
String createTime="2017-06-03";
String introduce="灵图图书馆走进你的心扉";
%>
<head>
<title>图书馆管理系统</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
</head>
<script type="text/javascript">
function checkForm(form){
	for(i=0;i<form.length;i++){
		if(form.elements[i].value==""){
			alert("请将信息添写完整!");
			form.elements[i].focus();
			return false;
		}
	}
}
</script>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：系统设置 &gt; 图书馆信息 &gt;&gt;&gt;</div>
<div style="height:440px;padding-left:20px;">
  <form name="form1" method="post" action="library?action=libraryModify">
<%
if(libraryForm!=null){
	libraryname=libraryForm.getLibraryname();
	curator=libraryForm.getCurator();
	tel=libraryForm.getTel();
	address=libraryForm.getAddress();
	email=libraryForm.getEmail();
	url=libraryForm.getUrl();
	createTime=libraryForm.getCreateDate();
	introduce=libraryForm.getIntroduce();
}
%>
<ul>
	<li>图书馆名：<input name="libraryname" type="text" id="libraryname" value="<%=libraryname%>" size="30"></li>
	<li>馆　　长：<input name="curator" type="text" id="curator" size="30" value="<%=curator%>" ></li>
	<li>联系电话：<input name="tel" type="text" id="tel" size="30" value="<%=tel%>"></li>
	<li>联系地址：<input name="address" type="text" id="address" size="30" value="<%=address%>"></li>
	<li>联系邮箱：<input name="email" type="text" id="email" size="30" value="<%=email%>"></li>
	<li>网　　址：<input name="url" type="text" id="url" size="30" value="<%=url%>"></li>
	<li>建馆时间：<input name="createDate" type="text" id="createDate" size="30" value="<%=createTime%>">
      (日期格式：2012-06-22)</li>
	<li>简　　介：<textarea name="introduce" cols="50" rows="5" class="wenbenkuang" id="introduce"><%=introduce%></textarea></li>
	<li style="padding-left:200px;"><input name="Submit" type="submit" value="保存" onClick="return checkForm(form1)">
        &nbsp;
        <input name="Submit2" type="reset" value="取消"></li>
</ul>
 </form>
</div>
</section>
<%@ include file="copyright.jsp"%>

</body>
</html>
