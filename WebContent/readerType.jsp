<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.ReaderTypeDaoImpl" %>
<%@ page import="cn.jju.library.entity.ReaderTypeForm" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
Collection coll=(Collection)request.getAttribute("readerType");
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
<div id="area">当前位置：读者管理 &gt; 读者类型管理 &gt;&gt;&gt;</div>
<div style="height:300px;padding-left:20px;">
<%
if(coll==null || coll.isEmpty()){
%>
         <div style="text-align: center;height:36px;">暂无读者类型信息！</div>
         <div style="text-align: left;height:20px;"><a href="#" onClick="window.open('readerType_add.jsp','','width=292,height=175')">添加读者类型信息</a></div>
 <%
}else{
  //通过迭代方式显示数据
  Iterator it=coll.iterator();
  int ID=0;
  String name="";
  int number=0;
  %>
  <div style="text-align: right;padding:8px;"><a href="#" onClick="window.open('readerType_add.jsp','','width=292,height=175')">添加读者类型信息</a></div> 
  <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6b83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="35%" bgcolor="#F9D16B">读者类型名称</td>
    <td width="35%" bgcolor="#F9D16B">可借数量</td>
    <td width="16%" bgcolor="#F9D16B">修改</td>
    <td width="14%" bgcolor="#F9D16B">删除</td>
  </tr>
<%
  while(it.hasNext()){
    ReaderTypeForm readerTypeForm=(ReaderTypeForm)it.next();
	ID=readerTypeForm.getId().intValue();
	name=readerTypeForm.getName();
	number=readerTypeForm.getNumber();
	%> 
  <tr>
    <td style="padding:5px;">&nbsp;<%=name%></td>
    <td style="padding:5px;">&nbsp;<%=number%></td>
    <td align="center"><a href="#" onClick="window.open('readerType?action=readerTypeModifyQuery&ID=<%=ID%>','','width=292,height=175')">修改</a></td>
    <td align="center"><a href="readerType?action=readerTypeDel&ID=<%=ID%>">删除</a></td>
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
