<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.jju.library.cart.CarItem"%>
<%@ page import="cn.jju.library.entity.*,java.util.*"%>
<jsp:useBean id="car" class="cn.jju.library.cart.Car" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
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
}

.word_orange {
	font-size: 12pt;
	color: #FF6600;
}
#buy{
font-size: 12pt;
	color: #FF6600;
	text-align:center;
	padding:5px 5px;
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
<body>
	<div id="index">
		<div id="header"></div>
		<div id="content">
			<div style="text-align: left; padding: 20px 20px; height: 30px;"
				class="word_orange">
				当前位置:图书购买 &gt;&gt;&gt;&nbsp;<a href="ProductIndex.jsp">&gt;&gt;&gt;&nbsp;返回图书义卖首页
				</a>
			</div>

			<div id="content_c">
				<table align="center" border="1">
					<tr>
						<th>名称</th>
						<th>单价</th>
						<th>小计</th>
						<th>删除</th>
						<th>更新</th>
					</tr>
					<%
						Collection<CarItem> carItems = car.getItemMap().values();
						for (CarItem c : carItems) {
					%>
					<tr>
						<td><%=c.getItem().getProduct().getProductName()%></td>
						<td><%=c.getItem().getPrice()%></td>
						<td><%=c.getTotal()%></td>
						<!-- 小计 -->
						<td><a href="DeleteItem.jsp?id=<%=c.getItem().getId()%> ">删除</a></td>
						<td>
							<form action="UpdateCar.jsp">
								<input type="hidden" value="<%=c.getItem().getId()%>"
									name="id"> <input type="text"
									value="<%=c.getItem().getQuantity()%>" name="quantity">
								<input type="submit" value="更新">
							</form>
						</td>
					</tr>
					<%
						}
					%>
					<tr>
						<%-- <td>合计</td>
		<td colspan=4><%= car.getSubTotal() %></td> --%>
						<td colspan=7 align="right"><br>你选择的商品的总金额:<%=car.getSubTotal()%>元
						
					</tr>



				</table>
			
			<div id="buy"><a href="CheckOut.jsp">结算</a> <a href="Clear.jsp">清空购物车</a> <a
					href="ProductIndex.jsp">继续购物</a></div>
			</div>		
		</div>
		<%@ include file="../copyright.jsp"%>
	</div>
</body>
</html>