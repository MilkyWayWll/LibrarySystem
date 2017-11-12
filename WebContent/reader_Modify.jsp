<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="cn.jju.library.daoImpl.ReaderDaoImpl" %>
<%@ page import="cn.jju.library.daoImpl.ReaderTypeDaoImpl" %>
<%@ page import="cn.jju.library.entity.ReaderForm" %>
<%@ page import="cn.jju.library.entity.ReaderTypeForm"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<%
String str=null;
ReaderTypeDaoImpl readerTypeDAO=new ReaderTypeDaoImpl();
Collection coll=(Collection)readerTypeDAO.query(str);
Iterator it=coll.iterator();
ReaderForm readerForm=(ReaderForm)request.getAttribute("readerQueryif");
%>
<script language="jscript">
function check(form){
	if(form.name.value==""){
		alert("请输入读者姓名!");form.name.focus();return false;
	}
	if(form.paperNO.value==""){
		alert("请输入证件号码!");form.paperNO.focus();return false;
	}
}
</script>
<head>
<title>图书馆管理系统</title>
<meta charset="UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<style type="text/css">
div li{
	padding:5px;
}
</style>
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<section>
<div id="area">当前位置：读者管理 &gt; 读者档案管理 &gt; 修改读者信息 &gt;&gt;&gt;</div>
<div style="height:485px;padding-left:20px;">
<%  int ID=readerForm.getId().intValue();
  String name=readerForm.getName();
  String sex=readerForm.getSex();  
  String barcode=readerForm.getBarcode();
  String vocation=readerForm.getVocation();
  String birthday=readerForm.getBirthday();
  String paperType=readerForm.getPaperType();
  String paperNO=readerForm.getPaperNO();
  String tel=readerForm.getTel();
  String email=readerForm.getEmail();
  String createDate=readerForm.getCreateDate();
  String remark=readerForm.getRemark();
  String operator=readerForm.getOperator();
  int typeid=readerForm.getTypeid();
  String typename=readerForm.getTypename();
  String typeName="";
  int typeID=0;
  %>
	<form name="form1" method="post" action="reader?action=readerModify">
  <ul>
		<li>姓　　名：<input name="name" type="text" value="<%=name%>" readonly="yes"> 
          *         
          <input name="id" type="hidden" id="id" value="<%=ID%>"></li>
		<li>性　　别：<input name="sex" type="radio" class="noborder" id="radiobutton" value="男" <%if("男".equals(sex)) out.println("checked");%>>
          <label for="radiobutton">男 </label>
          <label>
          <input name="sex" type="radio" class="noborder" value="女" <%if("女".equals(sex)) out.println("checked");%>>
          女</label></li>
		<li>条&nbsp; 形 &nbsp;码：<input name="barcode" type="text" id="barcode" value="<%=barcode%>" readonly="yes"></li>
		<li>读者类型：<select name="typeid" class="wenbenkuang" id="typeid">
<%
  while(it.hasNext()){
    ReaderTypeForm readerTypeForm=(ReaderTypeForm)it.next();
	typeID=readerTypeForm.getId().intValue();
	typeName=readerTypeForm.getName();
	%> 		
				
          <option value="<%=typeID%>" <%if(typeid==typeID) out.println("selected");%>><%=typeName%></option>
<%}%> 
        </select></li>
		<li>职　　业：<input name="vocation" type="text" id="vocation" value="<%=vocation%>"></li>
		<li>出生日期：<input name="birthday" type="text" id="birthday" value="<%=birthday%>"></li>
		<li>有效证件：<select name="paperType" class="wenbenkuang" id="paperType">
          <option value="身份证"<%if("身份证".equals(paperType)) out.println(" selected");%>>身份证</option>
          <option value="学生证"<%if("学生证".equals(paperType)) out.println(" selected");%>>学生证</option>
          <option value="军官证"<%if("军官证".equals(paperType)) out.println(" selected");%>>军官证</option>
          <option value="工作证"<%if("工作证".equals(paperType)) out.println(" selected");%>>工作证</option>
                        </select></li>
		<li>证件号码：<input name="paperNO" type="text" id="paperNO" value="<%=paperNO%>"> 
          * </li>
		<li>登记日期：<input name="paperNO2" type="text" id="paperNO2" value="<%=createDate%>"></li>
		<li>电　　话：<input name="tel" type="text" id="tel" value="<%=tel%>"></li>
		<li>Email地址：<input name="email" type="text" id="email" value="<%=email%>" size="50">
          <input name="operator" type="hidden" id="operator" value="<%=operator%>"></li>
		<li>操&nbsp;作&nbsp;员：<input name="operator" type="text" id="operator" value="<%=operator%>" readonly="yes"></li>
		<li>备　　注：<textarea name="remark" cols="50" rows="5" class="wenbenkuang" id="remark"><%=remark%></textarea></li>
		<li><input name="Submit" type="submit" value="保存" onClick="return check(form1)">
&nbsp;
<input name="Submit2" type="button" value="返回" onClick="history.back()"></li>
	</ul>	
	</form>
</div>
</section>
<%@ include file="copyright.jsp"%>
</body>
</html>
