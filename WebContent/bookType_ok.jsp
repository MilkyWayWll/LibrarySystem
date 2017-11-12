<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>操作成功!</title>
<meta charset="UTF-8">
</head>

<body>
<%int para=Integer.parseInt(request.getParameter("para"));
switch(para){
	case 1:
	%>
		<script language="javascript">
		alert("图书类型信息添加成功!");
		opener.location.reload();
		window.close();
		</script>	
	<%	break;
	case 2:
	%>
		<script language="javascript">
		alert("图书类型信息修改成功!");
		opener.location.reload();
		window.close();
		</script>		
	<%	break;
	case 3:
	%>
		<script language="javascript">
		alert("图书类型信息删除成功!");
		window.location.href="bookType?action=bookTypeQuery";
		</script>		
	<%	break;
}
%>
</body>
</html>