<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
</head>

<body>
<%
session.invalidate();
out.println("<script language='javascript'>");
out.println("window.location.href='index.jsp'");
out.println("</script>");
%>	


</body>
</html>
