<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>

<%@ page import="cn.jju.library.daoImpl.BookDaoImpl" %>
<%@ page import="cn.jju.library.daoImpl.BookTypeDaoImpl" %>
<%@ page import="cn.jju.library.entity.BookForm" %>
<%@ page import="cn.jju.library.entity.BookTypeForm"%>
<%@ page import="cn.jju.library.daoImpl.BookCaseDaoImpl" %>
<%@ page import="cn.jju.library.entity.BookCaseForm" %>
<%@ page import="cn.jju.library.daoImpl.PublishingDaoImpl" %>
<%@ page import="cn.jju.library.entity.PublishingForm" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
String str=null;
BookTypeDaoImpl bookTypeDaoImpl=new BookTypeDaoImpl();
Collection coll_type=(Collection)bookTypeDaoImpl.query(str);
if(coll_type==null || coll_type.isEmpty()){
	out.println("<script>alert('请先录入图书类型信息!');history.back(-1);</script>");
}else{
	  Iterator it_type=coll_type.iterator();
	  int typeID=0;
	  String typename1="";
	  BookCaseDaoImpl bookcaseDaoImpl=new BookCaseDaoImpl();
	  String str1=null;
	  Collection coll_bookcase=(Collection)bookcaseDaoImpl.query(str1);
	  if(coll_bookcase==null || coll_bookcase.isEmpty()){
	  	out.println("<script>alert('请先录入书架信息!');history.back(-1);</script>");
	  }else{
	  	Iterator it_bookcase=coll_bookcase.iterator();
	  	int bookcaseID=0;
	  	String bookcasename="";
	  PublishingDaoImpl pubDAO=new PublishingDaoImpl();
	  String str2=null;
	  Collection coll_pub=(Collection)pubDAO.query(str2);
	  if(coll_pub==null || coll_pub.isEmpty()){
	  	out.println("<script>alert('请先录入出版社信息!');history.back(-1);</script>");
	  }else{	
	  	Iterator it_pub=coll_pub.iterator();
	  	String isbn="";
	  	String pubname="";	 
		BookForm bookForm=(BookForm)request.getAttribute("bookQueryif"); 	
%>
<script type="text/javascript">
function check(form){
	if(form.barcode.value==""){
		alert("请输入条形码!");form.barcode.focus();return false;
	}
	if(form.bookName.value==""){
		alert("请输入图书姓名!");form.bookName.focus();return false;
	}
	if(form.price.value==""){
		alert("请输入图书定价!");form.price.focus();return false;
	}
}
</script>
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：图书管理 &gt; 图书档案管理 &gt; 修改图书信息 &gt;&gt;&gt;</div>
<div style="height:432px;padding-left:20px;">
	<form name="form1" method="post" action="book?action=bookModify">
<%	int ID=bookForm.getId().intValue();
	String bookname=bookForm.getBookName();
	String barcode=bookForm.getBarcode();
	if(barcode==null) barcode="";
	int TypeId=bookForm.getTypeId();
	String typename=bookForm.getTypeName();
	String author=bookForm.getAuthor();
	String translator=bookForm.getTranslator();	
	String ISBN=bookForm.getIsbn();
	String publishing=bookForm.getPublishing();
	Float price=bookForm.getPrice();
	int pages=bookForm.getPage();
	int bookcaseid=bookForm.getBookcaseid();
	String bookcase=bookForm.getBookcaseName();	
	String inTime=bookForm.getInTime();
	String operator=bookForm.getOperator();
  %>
  <ul>
		<li>条 形 码：<input name="barcode" type="text" id="barcode" value="<%=barcode%>">*
		 <input name="id" type="hidden" id="id" value="<%=ID%>"></li>
		<li>图书名称：<input name="bookName" type="text" id="bookName" value="<%=bookname%>" size="60">*</li>
		<li>图书类型：		<select name="typeId" class="wenbenkuang" id="typeId">
<%
  while(it_type.hasNext()){
    BookTypeForm bookTypeForm=(BookTypeForm)it_type.next();
	typeID=bookTypeForm.getId().intValue();
	typename1=bookTypeForm.getTypeName();
	%> 		
				
          <option value="<%=typeID%>" <%if(TypeId==typeID) out.println("selected");%>><%=typename1%></option>
<%}%> 
        </select></li>
		<li>作　　者：<input name="author" type="text" id="author" value="<%=author%>"></li>
		<li>译　　者：<input name="translator" type="text" id="translator" value="<%=translator%>"></li>
		<li>出 版 社：<select name="isbn" class="wenbenkuang">
<%
  while(it_pub.hasNext()){
    PublishingForm pubForm=(PublishingForm)it_pub.next();
	isbn=pubForm.getIsbn();
	pubname=pubForm.getPubname();
	%> 		
				
          <option value="<%=isbn%>" <%if(isbn.equals(ISBN)) out.println("selected");%>><%=pubname%></option>
<%}%> 
        </select> </li>
		<li>价　　格：<input name="price" type="text" id="price" value="<%=price%>"> 
          (元) * </li>
		<li>页　　码：<input name="page" type="text" id="page" value="<%=pages%>"></li>
		<li>书　　架：<select name="bookcaseid" class="wenbenkuang" id="bookcaseid">
<%
  while(it_bookcase.hasNext()){
    BookCaseForm bookCaseForm=(BookCaseForm)it_bookcase.next();
	bookcaseID=bookCaseForm.getId().intValue();
	bookcasename=bookCaseForm.getName();
	%> 		
				
          <option value="<%=bookcaseID%>" <%if(bookcaseid==bookcaseID) out.println("selected");%>><%=bookcasename%></option>
<%}%> 
        </select>
          <input name="operator" type="hidden" id="operator" value="<%=manager%>"></li>
		<li><input name="Submit" type="submit" value="保存" onClick="return check(form1)">
&nbsp;
<input name="Submit2" type="button" value="返回" onClick="history.back()"></li>
</ul>
	</form>

<%}
}
}%>
</div>
</section>
<%@ include file="copyright.jsp"%>
</body>
</html>
