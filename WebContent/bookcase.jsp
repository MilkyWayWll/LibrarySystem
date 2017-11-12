<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.BookCaseDaoImpl" %>
<%@ page import="cn.jju.library.entity.BookCaseForm" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
Collection coll=(Collection)request.getAttribute("bookcase");
%>
<head>
<title>图书馆管理系统</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：系统设置 &gt; 书架设置 &gt;&gt;&gt;</div>
<div style="height:300px;padding-left:20px;">
<%
if(coll==null || coll.isEmpty()){
%>
         <div style="text-align: center;height:36px;">暂无书架信息！</div>
         <div style="text-align: left;height:20px;"><a href="#" onClick="window.open('bookcase_add.jsp','','width=292,height=175')">添加书架信息</a></div>
 <%
}else{
  //通过迭代方式显示数据
  Iterator it=coll.iterator();
  int ID=0;
  String name="";
  %>
 <div style="text-align: right;padding:8px;"><a href="#" onClick="window.open('bookcase_add.jsp','','width=292,height=175')">添加书架信息</a></div>
  <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="70%" bgcolor="#F9D16B">书架名称</td>
    <td width="16%" bgcolor="#F9D16B">修改</td>
    <td width="14%" bgcolor="#F9D16B">删除</td>
  </tr>
<%
  while(it.hasNext()){
    BookCaseForm bookCaseForm=(BookCaseForm)it.next();
	ID=bookCaseForm.getId().intValue();
	name=bookCaseForm.getName();
	%> 
  <tr>
    <td style="padding:5px;"><%=name%></td>
    <td align="center"><a href="#" onClick="window.open('bookCase?action=bookCaseModifyQuery&ID=<%=ID%>','','width=292,height=175')">修改</a></td>
    <td align="center"><a href="bookCase?action=bookCaseDel&ID=<%=ID%>">删除</a></td>
  </tr>
<%
  }
}
%>  
</table>
</div>
</section>
<%@ include file="copyright.jsp"%>
</body>
</html>
