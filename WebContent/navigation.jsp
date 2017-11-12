<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="cn.jju.library.daoImpl.ManagerDaoImpl"%>
<%@ page import="cn.jju.library.entity.ManagerForm"%>

<%
ManagerDaoImpl managerDAO=new ManagerDaoImpl();
ManagerForm form1=(ManagerForm)managerDAO.query_p("manager");
int sysset1=1;
int readerset1=1;
int bookset1=1;
int borrowback1=1;
int sysquery1=1;
if(form1!=null){
	sysset1=form1.getSysset();
	readerset1=form1.getReaderset();
	bookset1=form1.getBookset();
	borrowback1=form1.getBorrowback();
	sysquery1=form1.getSysquery();
}

%>
<style>
nav ul{
	list-style:none;

	margin: 0px;
	padding: 0px;
}
nav li{
	height:24px;
	float:left;
	padding-top:6px;
}
nav{
	width:778px; 
	background-color:#FFF;
	height:39px;padding: 0px;
	margin: 0px;
	background-image:url(Images/navigation_bg_bottom.gif);
	background-position: bottom;
	background-repeat: repeat-x; 
}
</style>
<script src="JS/onclock.JS"></script>
<script src="JS/menu.JS"></script>
		<script type="text/javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="logout.jsp";
				}
			}
		</script>
<div class="menuskin" id="popmenu"
      onmouseover="clearhidemenu();highlightmenu(event,'on')"
      onmouseout="highlightmenu(event,'off');dynamichide(event)" style="Z-index:100;position:absolute;"></div>
<nav>
	<ul>
    	<li style="width:230px;background-color:#fdfdfd;text-align:center"><span id="bgclock" class="word_white">
    	<script type=text/javascript>
		document.write("<span id='labtime' width='120px' Font-Size='9pt'></span>")
		setInterval("labtime.innerText=new Date().toLocaleString()",1000)
		</script>
    	</span></li>
        <li style="width:538px;background-color:#effbf7;text-align: right;padding-right:10px;" class="word_white">
        <a href="main.jsp" class="word_white">首页</a> |
        <%if(sysset1==1){%><a  onmouseover=showmenu(event,sysmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:pointer" >系统设置</a> | <%}%>
        <%if(readerset1==1){%>
        <a  onmouseover=showmenu(event,readermenu) onmouseout=delayhidemenu() style="CURSOR:pointer"  class="word_white">读者管理</a> | <%}%>
        <%if(bookset1==1){%><a  onmouseover=showmenu(event,bookmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:pointer" >图书管理</a> | <%}%>
        <%if(borrowback1==1){%><a  onmouseover=showmenu(event,borrowmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:pointer">图书借还</a> | <%}%>
        <%if(sysquery1==1){%><a  onmouseover=showmenu(event,querymenu) onmouseout=delayhidemenu()  class="word_white" style="CURSOR:pointer" >系统查询</a> | 
        <%}%><a  href="manager?action=querypwd" class="word_white">更改口令</a> | <a href="#" onClick="quit()" class="word_white">退出系统</a>
        </li>
    </ul>
</nav>
