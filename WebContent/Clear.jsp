<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="car" class="cn.jju.library.cart.Car"  scope="session"/>
<% 
    car.clear();
 	//response.sendRedirect("ProductIndex.jsp");
 	response.sendRedirect("ViewCar.jsp");
 %>