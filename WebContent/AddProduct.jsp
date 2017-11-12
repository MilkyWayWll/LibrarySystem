<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% %>
<!-- 出现加个购物车 -->
<jsp:useBean id="car" class="cn.jju.library.cart.Car"  scope="session"/>
<jsp:useBean id="productDao" class="cn.jju.library.daoImpl.ProductDaoImpl" />
<jsp:useBean id="product" class="cn.jju.library.entity.Product" />
<jsp:setProperty name ="product" property="*" />
<jsp:useBean id="item" class="cn.jju.library.entity.Item" />

<%
	 product = productDao.getById(product.getId());
	 item.setId(product.getId());
	 item.setProductId(product.getId());
	 item.setPrice(product.getPrice());
	 item.setQuantity(1);
	 
	 item.setProduct(product);
	 
	 car.addItem(item,true);
	 response.sendRedirect("ViewCar.jsp"); /* 显示购物车内容 */
	 
	 %>