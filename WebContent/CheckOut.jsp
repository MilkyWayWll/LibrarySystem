<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cn.jju.library.entity.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="cn.jju.library.cart.*" %>
<jsp:useBean id="car" class="cn.jju.library.cart.Car"  scope="session"/>
<jsp:useBean id="indentDao" class="cn.jju.library.daoImpl.IndentDaoImpl"></jsp:useBean>
<jsp:useBean id="itemDao" class="cn.jju.library.daoImpl.ItemDaoImpl" />
<jsp:useBean id="indent" class="cn.jju.library.entity.Indent" />
<!-- 结算 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

</head>
<body>
	
			<%

	 int IndentId;
	   Collection<CarItem> carItem=car.getItemMap().values();
	   indent.setUserid(18);
	   indent.setAddress("九江学院");
	   indent.setTotalprice(car.getSubTotal());

	   IndentId=indentDao.addIndent(indent);
	   out.print(IndentId+"</br>");
	  
	  for(CarItem c :carItem){
		  
		  Item item=c.getItem();
		  
		  item.setIndentId(IndentId);
		  itemDao.addItem(item);
		  
	  }
	 car.clear();
	 response.sendRedirect("IndentItem.jsp?indentId="+IndentId);
%>
		
</body>
</html>