<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.BookDaoImpl" %>
<%@ page import="cn.jju.library.entity.BookForm" %>
<%@ page import="java.util.*"%>
<%@ page import="cn.jju.library.dao.ChStr"%>

<!DOCTYPE HTML>
<html>
<%
Collection<BookForm> coll=(Collection<BookForm>)request.getAttribute("book");
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
<div id="area">当前位置：图书管理 &gt; 图书档案管理 &gt;&gt;&gt;</div>
<div style="height:300px;padding-left:20px;">
<%
if(coll==null || coll.isEmpty()){
%>
         <div style="text-align: center;height:36px;">暂无图书信息！</div>
         <div style="text-align: left;height:20px;"><a href="book_add.jsp">添加图书信息</a></div>
 <%
}else{
  //通过迭代方式显示数据
  Iterator it=coll.iterator();
  int ID=0;
  String bookname="";
  String barcode="";
  String typename="";
  String publishing="";
  String bookcase="";
  int storage=0;
  %>
<div style="text-align: right;padding:8px;"><a href="book_add.jsp">添加图书信息</a></div>  
  <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="13%" bgcolor="#F9D16B">条形码</td>  
    <td width="26%" bgcolor="#F9D16B">图书名称</td>
    <td width="15%" bgcolor="#F9D16B">图书类型</td>
    <td width="14%" bgcolor="#F9D16B">出版社</td>
    <td width="12%" bgcolor="#F9D16B">书架</td>
    <td width="9%" bgcolor="#F9D16B">修改</td>
    <td width="5%" bgcolor="#F9D16B">删除</td>
  </tr>
<%
  while(it.hasNext()){
    BookForm bookForm=(BookForm)it.next();
	ID=bookForm.getId().intValue();
	bookname=bookForm.getBookName();
	barcode=chStr.nullToString(bookForm.getBarcode(),"&nbsp;");
	typename=bookForm.getTypeName();
	publishing=bookForm.getPublishing();
	bookcase=chStr.nullToString(bookForm.getBookcaseName(),"&nbsp;");
	%> 
  <tr>
    <td style="padding:5px;">&nbsp;<%=barcode%></td>  
    <td style="padding:5px;"><a href="book?action=bookDetail&ID=<%=ID%>"><%=bookname%></a></td>
    <td style="padding:5px;">&nbsp;<%=typename%></td>  
    <td style="padding:5px;">&nbsp;<%=publishing%></td>  
    <td style="padding:5px;">&nbsp;<%=bookcase%></td>  
	
    <td align="center"><a href="book?action=bookModifyQuery&ID=<%=ID%>">修改</a></td>
    <td align="center"><a href="book?action=bookDel&ID=<%=ID%>">删除</a></td>
  </tr>
<%
  }
}
%>  
</table></td>
      </tr>
    </table>
</div>
</section>
<%@ include file="copyright.jsp"%>
</body>
</html>
