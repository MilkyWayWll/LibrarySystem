<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="cn.jju.library.daoImpl.BorrowDaoImpl"%>

<%@ page import="cn.jju.library.entity.BorrowForm"%>
<%@ page import="java.util.*"%>

<!DOCTYPE HTML>
<html>
<meta charset="UTF-8">
<head>
<title>图书馆管理系统</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp" %>
<%
BorrowDaoImpl borrowDaoImpl=new BorrowDaoImpl();
Collection coll_book=(Collection)borrowDaoImpl.bookBorrowSort();
%>
<section>
<div style="text-align:right;padding-right:10px;height:30px;"class="word_orange">当前位置：首页 &gt;&gt;&gt;&nbsp;</div>
<div style="height:34px;clear:both" ><img src="Images/bookborrow.gif" height="34px"></div>
<div style="height:300px;padding-left:20px;">
<table width="95%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#B7B6B6" bordercolorlight="#FFFFFF">
                  <tr align="center">
                    <td width="5%" height="25">排名</td>
					<td width="10%">图书条形码</td>
					<td width="24%">图书名称</td>
					<td width="10%">图书类型</td>
					<td width="10%">书架</td>
					<td width="14%">出版社</td>
					<td width="11%">作者</td>
					<td>定价(元)</td>
				    <td>借阅次数</td>
                  </tr>
					<%if(coll_book!=null && !coll_book.isEmpty()){
						  Iterator it_book=coll_book.iterator();
						  int i=1;
					  int degree=0;
					  String bookname="";
					  String typename="";
					  String barcode_book="";
					  String bookcase="";
					  String pub="";
					  String author="";
					  String translator="";
					  Float price=new Float(0);
						  while(it_book.hasNext() && i<6){
						  BorrowForm borrowForm=(BorrowForm)it_book.next();
						bookname=borrowForm.getBookName();
							barcode_book=borrowForm.getBookBarcode();
							typename=borrowForm.getBookType();
						degree=borrowForm.getDegree();
						bookcase=borrowForm.getBookcaseName();
							pub=borrowForm.getPubName();
							author=borrowForm.getAuthor();
							price=borrowForm.getPrice();
					
						%> 
                  <tr>
                    <td height="25" align="center"><%=i%></td>
					<td style="padding:5px;">&nbsp;<%=barcode_book%></td>
					<td style="padding:5px;"><%=bookname%></td>
					<td style="padding:5px;"><%=typename%></td>
					<td align="center">&nbsp;<%=bookcase%></td>
					<td align="center">&nbsp;<%=pub%></td>
					<td width="11%" align="center"><%=author%></td>
					<td width="8%" align="center"><%=price%></td>
				    <td width="8%" align="center"><%=degree%></td>
                  </tr>
						<%
						i++;
						}
					}%>
                </table>
		 <div style="text-align:left;float:left;padding:10px;"><a href=borrow?action=bookBorrowSort><img src="Images/more.GIF" width="50" height="20" border="0">&nbsp;</a></div>
		 <div style="text-align:right;float:right;padding:10px;color:red;"><a href="ProductIndex.jsp">友情链接&nbsp;</a></div>
     </div>

</section>

<%@ include file="copyright.jsp"%>
</body>
</html>
