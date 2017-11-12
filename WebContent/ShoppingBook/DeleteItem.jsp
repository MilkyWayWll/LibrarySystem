<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="car" class="cn.jju.library.cart.Car"  scope="session"/>
<jsp:useBean id="item" class="cn.jju.library.entity.Item" />
<jsp:setProperty name="item" property="*" />

<% 
	car.removeItemById(item.getId());
	response.sendRedirect("ViewCar.jsp");
%>