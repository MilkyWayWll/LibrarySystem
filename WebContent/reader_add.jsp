<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.ReaderDaoImpl" %>
<%@ page import="cn.jju.library.daoImpl.ReaderTypeDaoImpl" %>
<%@ page import="cn.jju.library.entity.ReaderForm" %>
<%@ page import="cn.jju.library.entity.ReaderTypeForm"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
String str=null;
ReaderTypeDaoImpl readerTypeDAO=new ReaderTypeDaoImpl();
Collection coll=(Collection)readerTypeDAO.query(str);
if(coll==null || coll.isEmpty()){
	out.println("<script>alert('请先录入读者类型信息!');history.back(-1);</script>");
}else{
	  Iterator it=coll.iterator();
	  int ID=0;
	  String name="";
%>
<script language="jscript">
function check(form){
	if(form.name.value==""){
		alert("请输入读者姓名!");form.name.focus();return false;
	}
	if(form.barcode.value==""){
		alert("请输入条形码!");form.barcode.focus();return false;
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
<div id="area">当前位置：读者管理 &gt; 读者档案管理 &gt; 添加读者信息 &gt;&gt;&gt;</div>
<div style="height:430px;padding-left:20px;">

	<form name="form1" method="post" action="reader?action=readerAdd">
	<ul>
		<li>姓　　名：<input name="name" type="text"> 
          * </li>
		<li>性　　别：<input name="sex" type="radio" class="noborder" id="radiobutton" value="男" checked>
          <label for="radiobutton">男 </label>
          <label>
          <input name="sex" type="radio" class="noborder" value="女">
          女</label></li>
		<li>条&nbsp; 形 &nbsp;码：<input name="barcode" type="text" id="barcode"></li>
		<li>读者类型：<select name="typeid" class="wenbenkuang" id="typeid">
<%
  while(it.hasNext()){
    ReaderTypeForm readerTypeForm=(ReaderTypeForm)it.next();
	ID=readerTypeForm.getId().intValue();
	name=readerTypeForm.getName();
	%> 		
				
          <option value="<%=ID%>"><%=name%></option>
<%}%> 
        </select>    </li>
		<li>职　　业：<input name="vocation" type="text" id="vocation"></li>
		<li>出生日期：<input name="birthday" type="text" id="birthday"></li>
		<li>有效证件：<select name="paperType" class="wenbenkuang" id="paperType">
          <option value="身份证" selected>身份证</option>
          <option value="学生证">学生证</option>
          <option value="军官证">军官证</option>
          <option value="工作证">工作证</option>
                        </select></li>
		<li>证件号码：<input name="paperNO" type="text" id="paperNO"> *</li>
		<li>电　　话：<input name="tel" type="text" id="tel"></li>
		<li>Email地址：<input name="email" type="text" id="email" size="50">
          <input name="operator" type="hidden" id="operator" value="<%=manager%>"></li>
		<li>备　　注：<textarea name="remark" cols="50" rows="5" class="wenbenkuang" id="remark"></textarea></li>
		<li><input name="Submit" type="submit" value="保存" onClick="return check(form1)">
&nbsp;
<input name="Submit2" type="button" value="返回" onClick="history.back()"></li>
	</ul>
	</form>
</div>
</section>
<%@ include file="copyright.jsp"%>
<%}%>
</body>
</html>
