<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.BookDaoImpl" %>
<%@ page import="cn.jju.library.daoImpl.BookTypeDaoImpl" %>
<%@ page import="cn.jju.library.entity.BookForm" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
BookForm bookForm=(BookForm)request.getAttribute("bookDetail");
%>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：图书管理 &gt; 图书档案管理 &gt; 图书详细信息 &gt;&gt;&gt</div>
<div style="height:492px;padding-left:20px;">
<%  
	int ID=bookForm.getId().intValue();
	String bookname=bookForm.getBookName();
	String barcode=bookForm.getBarcode();
	if(barcode==null) barcode="";
	String typename=bookForm.getTypeName();
	String author=bookForm.getAuthor();
	String translator=bookForm.getTranslator();	
	String publishing=bookForm.getPublishing();
	Float price=bookForm.getPrice();
	int pages=bookForm.getPage();
	String bookcase=bookForm.getBookcaseName();	

	String inTime=bookForm.getInTime();
	String operator=bookForm.getOperator();
  %>
  <ul>
		<li>条 形 码：<input name="barcode" type="text" id="barcode" value="<%=barcode%>"></li>
		<li>图书名称：<input name="bookName" type="text" id="bookName" value="<%=bookname%>" size="60">*</li>
		<li>图书类型：<input name="vocation" type="text" id="vocation" value="<%=typename%>"></li>
		<li>作　　者：<input name="author" type="text" id="author" value="<%=author%>"></li>
		<li>译　　者：<input name="translator" type="text" id="translator" value="<%=translator%>"></li>
		<li>出 版 社：<input name="paperType" type="text" value="<%=publishing%>" size="40"> </li>
		<li>价　　格：<input name="price" type="text" id="price" value="<%=price%>">(元)  </li>
		<li>页　　码：<input name="page" type="text" id="page" value="<%=pages%>"></li>
		<li>书　　架：<input name="tel" type="text" id="tel" value="<%=bookcase%>"></li>
		<li>入库时间：<input name="email" type="text" id="email" value="<%=inTime%>"></li>
		<li>操&nbsp;作&nbsp;员：<input name="operator" type="text" id="operator" value="<%=operator%>"></li>
		<li><input name="Submit2" type="button" value="返回" onClick="history.back()"></li>
</ul> 
  
  


    </div>
    </section>
<%@ include file="copyright.jsp"%>
</body>
</html>
