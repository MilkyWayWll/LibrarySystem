<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.ReaderDaoImpl" %>
<%@ page import="cn.jju.library.daoImpl.ReaderTypeDaoImpl" %>
<%@ page import="cn.jju.library.entity.ReaderForm" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
ReaderForm readerForm=(ReaderForm)request.getAttribute("readerDetail");
%>
<script language="jscript">
function check(form){
	if(form.name.value==""){
		alert("请输入读者姓名!");form.name.focus();return false;
	}
	if(form.paperNO.value==""){
		alert("请输入证件号码!");form.paperNO.focus();return false;
	}
}
</script>
<head>
<title>图书馆管理系统</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<style type="text/css">
div li{
	padding:5px;
}
</style>
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：读者管理 &gt; 读者档案管理 &gt; 读者详细信息 &gt;&gt;&gt;</div>
<div style="height:485px;padding-left:20px;">
<%  int ID=0;
  String name=readerForm.getName();
  String sex=readerForm.getSex();  
  String barcode=readerForm.getBarcode();
  String vocation=readerForm.getVocation();
  String birthday=readerForm.getBirthday();
  String paperType=readerForm.getPaperType();
  String paperNO=readerForm.getPaperNO();
  String tel=readerForm.getTel();
  String email=readerForm.getEmail();
  String createDate=readerForm.getCreateDate();
  String remark=readerForm.getRemark();
  String operator=readerForm.getOperator();
  int typeid=readerForm.getTypeid();
  String typename=readerForm.getTypename();
  %>
  <ul>
		<li>姓　　名：<input name="name" type="text" value="<%=name%>"> * </li>
		<li>性　　别：<input name="name" type="text" value="<%=sex%>"></li>
		<li>条&nbsp; 形 &nbsp;码：<input name="barcode" type="text" id="barcode" value="<%=barcode%>"></li>
		<li>读者类型：<input name="vocation" type="text" id="vocation" value="<%=typename%>"> </li>
		<li>职　　业：<input name="vocation" type="text" id="vocation" value="<%=vocation%>"></li>
		<li>出生日期：<input name="birthday" type="text" id="birthday" value="<%=birthday%>"></li>
		<li>有效证件：<input name="paperType" type="text" value="<%=paperType%>"></li>
		<li>证件号码：<input name="paperNO" type="text" id="paperNO" value="<%=paperNO%>"></li>
		<li>登记日期：<input name="paperNO2" type="text" id="paperNO2" value="<%=createDate%>"></li>
		<li>电　　话：<input name="tel" type="text" id="tel" value="<%=tel%>"></li>
		<li>Email地址：<input name="email" type="text" id="email" value="<%=email%>" size="50"></li>
		<li>操&nbsp;作&nbsp;员：<input name="operator" type="text" id="operator" value="<%=operator%>"></li>
		<li>备　　注：<textarea name="remark" cols="50" rows="5" class="wenbenkuang" id="remark"></textarea></li>
		<li><input name="Submit2" type="button" value="返回" onClick="history.back()"></li>
	</ul>
	</div>
	</section>
<%@ include file="copyright.jsp"%>
</body>
</html>
