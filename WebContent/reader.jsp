<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.ReaderDaoImpl" %>
<%@ page import="cn.jju.library.entity.ReaderForm" %>
<%@ page import="java.util.*"%>
<%@ page import="cn.jju.library.dao.ChStr"%>
<!DOCTYPE HTML>
<html>
<%
Collection coll=(Collection)request.getAttribute("reader");
ChStr chStr=new ChStr();
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
<div id="area">当前位置：读者管理 &gt; 读者档案管理 &gt;&gt;&gt;</div>
<div style="height:300px;padding-left:20px;">
<%
if(coll==null || coll.isEmpty()){
%>
 <div style="text-align: center;height:36px;">暂无读者信息！</div>
 <div style="text-align: left;height:20px;"><a href="reader_add.jsp">添加读者信息</a></div>
 <%
}else{
  //通过迭代方式显示数据
  Iterator it=coll.iterator();
  int ID=0;
  String name="";
  String typename="";
  String barcode="";
  String paperType="";
  String paperNO="";
  String tel="";
  String email="";
  %>
  <div style="text-align: right;padding:8px;"> <a href="reader_add.jsp">添加读者信息</a></div>  
 
  <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="13%" bgcolor="#F9D16B">条形码</td>  
    <td width="10%" bgcolor="#F9D16B">姓名</td>
    <td width="8%" bgcolor="#F9D16B">读者类型</td>
    <td width="12%" bgcolor="#F9D16B">证件类型</td>
    <td width="20%" bgcolor="#F9D16B">证件号码</td>
    <td width="12%" bgcolor="#F9D16B">电话</td>
    <td width="15%" bgcolor="#F9D16B">Email</td>
    <td width="5%" bgcolor="#F9D16B">修改</td>
    <td width="5%" bgcolor="#F9D16B">删除</td>
  </tr>
<%
  while(it.hasNext()){
    ReaderForm readerForm=(ReaderForm)it.next();
	ID=readerForm.getId().intValue();
	name=readerForm.getName();
	barcode=readerForm.getBarcode();
	typename=chStr.nullToString(readerForm.getTypename(),"&nbsp;");
	paperType=readerForm.getPaperType();
	paperNO=chStr.nullToString(readerForm.getPaperNO(),"&nbsp;");
	tel=chStr.nullToString(readerForm.getTel(),"&nbsp;");
	email=chStr.nullToString(readerForm.getEmail(),"&nbsp;");
	%> 
  <tr>
    <td style="padding:5px;"><%=barcode%></td>  
    <td style="padding:5px;"><a href="reader?action=readerDetail&ID=<%=ID%>"><%=name%></a></td>
    <td style="padding:5px;"><%=typename%></td>
    <td align="center"><%=paperType%></td>
    <td align="center"><%=paperNO%></td>
    <td align="center"><%=tel%></td>
    <td align="center"><%=email%></td>
    <td align="center"><a href="reader?action=readerModifyQuery&ID=<%=ID%>">修改</a></td>
    <td align="center"><a href="reader?action=readerDel&ID=<%=ID%>">删除</a></td>
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
