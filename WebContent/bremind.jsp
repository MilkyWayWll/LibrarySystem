<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.BorrowDaoImpl" %>
<%@ page import="cn.jju.library.entity.BorrowForm" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
Collection coll=(Collection)request.getAttribute("Bremind");
%>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
<meta charset="UTF-8">
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：系统查询 &gt; 借阅到期提醒  &gt;&gt;&gt;</div>
<div style="height:300px;padding-left:20px;">
<%
if(coll==null || coll.isEmpty()){
%>
     <div style="text-align: center;height:36px;">暂无到期提醒信息！</div>
          <%
}else{
  //通过迭代方式显示数据
  Iterator it=coll.iterator();
  String bookname="";
  String bookbarcode="";
  String readerbar="";
  String readername="";
  String borrowTime="";
  String backTime="";
  %>
          <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="15%" bgcolor="#F9D16B">图书条形码</td>
    <td width="28%" bgcolor="#F9D16B">图书名称</td>
    <td width="17%" bgcolor="#F9D16B">读者条形码</td>
    <td width="9%" bgcolor="#F9D16B">读者名称</td>
    <td width="15%" bgcolor="#F9D16B">借阅时间</td>
    <td width="16%" bgcolor="#F9D16B">应还时间</td>
    </tr>
<%
  while(it.hasNext()){
    BorrowForm borrowForm=(BorrowForm)it.next();
	bookname=borrowForm.getBookName();
	bookbarcode=borrowForm.getBookBarcode();
	readerbar=borrowForm.getReaderBarcode();
	readername=borrowForm.getReaderName();
	borrowTime=borrowForm.getBorrowTime();
	backTime=borrowForm.getBackTime();
	%>
  <tr>
    <td style="padding:5px;">&nbsp;<%=bookbarcode%></td>
    <td style="padding:5px;"><%=bookname%></td>
    <td style="padding:5px;">&nbsp;<%=readerbar%></td>
    <td style="padding:5px;">&nbsp;<%=readername%></td>
    <td style="padding:5px;">&nbsp;<%=borrowTime%></td>
    <td style="padding:5px;">&nbsp;<%=backTime%></td>
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
