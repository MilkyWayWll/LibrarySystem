<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.jju.library.dao.*"%>
<%@ page import="cn.jju.library.daoImpl.*"%>
<%@ page import="cn.jju.library.entity.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>义卖图书</title>
<style>
body {
	FONT-SIZE: 9pt;
	margin: 0px;
	BACKGROUND-COLOR: #F5F5F5;
	margin: 0px auto auto auto;
	width: 788px;
	clear: both;
}

#header {
	width: 788px;
	height: 190px;
	background-image: url(Images/bg.jpg);
}

#content {
	width: 788px;
	height:auto;
/* 	background: #FDFDFD; */
	background: url(Images/bg3.jpg);
}

#content_c {
	width: 688px;
	height: 500px;
	margin: 0px 40px;
}

.word_orange {
	font-size: 12pt;
	color: #FF6600;
}

</style>
</head>
<jsp:useBean id="productDao"
	class="cn.jju.library.daoImpl.ProductDaoImpl"></jsp:useBean>

<body>
	<div id="index">
		<div id="header"></div>
		<div id="content">
			<div style="text-align: left; padding: 20px 20px; height: 30px;"
				class="word_orange">当前位置:图书义卖 &gt;&gt;&gt;&nbsp;<a href="main.jsp">&gt;&gt;&gt;&nbsp;返回首页 </a></div>
		
			<div id="content_c">
			
				<table width="680" align="center" border="1">
					<tr>
						<th>Id</th>
						<th width="100px">商品名称</th>
						<th width="150px">商品简介</th>
						<th>商品展示</th>
						<th width="100px" >商品价格</th>
						<th>购买</th>
					</tr>
					<%
						List<Product> al = productDao.getAllProduct();
						for (Product p : al) {
					%>
					<tr>
						<td><%=p.getId() %>
						<td><%=p.getProductName()%></td>
						<td><%=p.getDescription()%></td>
						<td align="center"><img src="<%=p.getImg() %>" width="60px" height="60px"></td>
						<td><%=p.getPrice()%></td>
						<td><a href="AddProduct.jsp?id=<%=p.getId()%>"><img src="Images/buybutton.gif"></a></td>
					</tr>

					<%
						}
					%>
				</table>
			</div>
		</div>
		<%@ include file="../copyright.jsp"%>
	</div>

</body>
</html>