<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.jju.library.entity.*,java.util.*"%>
<%@ page import="cn.jju.library.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="indentDao" class="cn.jju.library.daoImpl.IndentDaoImpl"></jsp:useBean>
<jsp:useBean id="itemDao" class="cn.jju.library.daoImpl.ItemDaoImpl" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单明细</title>
<style type="text/css">
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
	background-image: url(../Images/bg.jpg);
}

#content {
	width: 788px;
	height: auto;
	/* 	background: #FDFDFD; */
	background: url(../Images/bg3.jpg);
}

#content_c {
	width: 688px;
	height: 440px;
	margin: 0px 40px;
	font-size: 12pt;
}

.word_orange {
	font-size: 12pt;
	color: #FF6600;
}

#buy {
	font-size: 12pt;
	color: #FF6600;
	text-align: center;
	padding: 5px 5px;
	list-style: none;
}

a:link {
	text-decoration: none;
	color: #000000;
	font: bold;
}

a:hover {
	color: #ff0000;
	text-decoration: none;
	list-style: none;
}
</style>
</head>
<%
	int indentId = Integer.parseInt(request.getParameter("indentId"));
	Indent indent = indentDao.getById(indentId);
	List<Item> listItem = itemDao.getByIndentId(indentId);
%>
<body>
	<div id="index">
		<div id="header"></div>
		<div id="content">
			<div style="text-align: left; padding: 20px 20px; height: 30px;"
				class="word_orange">
				当前位置:图书购买 &gt;&gt;&gt;&nbsp;
				
			</div>

			<div id="content_c">
				订单<br /> 订单Id：
				<%=indent.getId()%><br /> 订单账户ID：
				<%=indent.getUserid()%><br /> 订单地址：
				<%=indent.getAddress()%><br /> 订单价格：
				<%=indent.getTotalprice()%>
				
			
			<div style="text-align: right; height: 30px;"
				class="word_orange">
				<a href="ProductIndex.jsp">&gt;&gt;&gt;&nbsp;返回图书义卖首页
				</a>
			</div>
			</div>
		</div>
		<%@ include file="../copyright.jsp"%>
	</div>
</body>
</html>