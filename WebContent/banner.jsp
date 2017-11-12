<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String manager = (String) session.getAttribute("manager");
	//验证用户是否登录
	if (manager == null || "".equals(manager)) {
		response.sendRedirect("index.jsp");
	}
%>
<style>
#header {
	width: 778px;
	height: 200px;
	background-image: url(Images/bg.jpg);
}

#id {
	float: right;
	margin-right: 30px;
}
</style>
<div id="header">
	<div id="user">
		当前登录用户：<%=manager%>
	</div>
</div>
