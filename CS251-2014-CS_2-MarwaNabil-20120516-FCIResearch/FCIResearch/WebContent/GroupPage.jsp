<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FCI Research - Group</title>    
<link rel="stylesheet" href="css/postResearchPage.css" type="text/css"/>
</head>
<body>
    

<div class="Header1">
</div>
    <div class="Header">
    <a href="Login_Page.html">   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; "></a>
</div>
<div class="cont">         
    
<div class="Form">  
    

<%@ page import="dao.*" %>
<%@ page import="entities.*" %>

<%
String gName=request.getParameter("groupName_home");
session.setAttribute("groupName", gName);
GroupDao gD=new GroupDao();

if(!gD.groupExists(gName)){
	out.write("<script type='text/javascript'>\n");
	out.write("alert(' No Such Group ');\n");
	out.write("window.location.href='HomePage.jsp'");
	out.write("</script>\n");
}

%>

<form>
<input type="button" value="Show Groups" id="Button" onclick="window.location.href='showGroups.jsp'">
<input type="button" value="Delete Group" id="Button" onclick="window.location.href='deleteGroup'">
<input type="button" value="Edit Group" id="Button" onclick="window.location.href='editGroupPage.html'">
</form>
</div>
 <div class="space">                </div>

<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
    </div>
        


</body>
</html>